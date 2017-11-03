/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

import java.util.ArrayList;

/**
 *
 * @author Gerson Romano Barbieri Filho
 */
public class AlignmentAlgorithm
{
    
// <editor-fold defaultstate="collapsed" desc=" Private Fields ">
    private AlignmentAlgorithmSpecificity m_specificAlgorithm = null;
    private char[][] m_alignment = null;
    private ArrayList<Tuple<Integer,Integer>> m_path = new ArrayList<>();
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Set Methods ">
    public void setParamenters(int match, int mismatch, int gap, int gapExtension)
    {
        m_specificAlgorithm.setParameters(new AlgorithmParameters(match, mismatch, gap, gapExtension));
    }
    
    public void setAlgorithmsSpecificity(AlignmentAlgorithmSpecificity algorithm)
    {
        m_specificAlgorithm = algorithm;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Get Methods ">
    public char[][] getAlignment()
    {
        return m_alignment;
    }
    
    public ArrayList<Tuple<Integer,Integer>> getPath()
    {
        return m_path;
    }
    
    public ArrayList<String> getPathAsString()
    {
        ArrayList<String> path = new ArrayList<>();
        m_path.stream().forEach((pair) -> {
            path.add(String.format("[%d,%d]",pair.getFirstElement(),pair.getSecondElement()));
        });
        return path;
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Private Methods ">
    private int comparePair(char[] firstSeq, char[] secondSeq, int i, int j) {
        return firstSeq[i] == secondSeq[j] ? m_specificAlgorithm.getMatch() : m_specificAlgorithm.getMismatch();
    }
// </editor-fold>
 
// <editor-fold defaultstate="collapsed" desc=" Public Methods ">
    public void initialization(SubstitutionMatrix matrix) 
    {
        for (int i = 1; i < matrix.getNumberOfRows(); i++)
        {
            matrix.setScore(i, 0, m_specificAlgorithm.initializationValue(i));
            //matrix.setTraceBack(i, 0, EDirection.up,new Tuple<>(i-1, 0));
            matrix.setTraceBack(i, 0, m_specificAlgorithm.columnInitializationDirection(),new Tuple<>(i-1, 0));
        }
        for (int i = 1; i < matrix.getNumberOfColumns(); i++)
        {
            matrix.setScore(0, i, m_specificAlgorithm.initializationValue(i));
            //matrix.setTraceBack(0, i, EDirection.left, new Tuple<>(0, i-1));
            matrix.setTraceBack(0, i, m_specificAlgorithm.rowInitializationDirection(), new Tuple<>(0, i-1));
        }
    }
    
    public void filling(SubstitutionMatrix subMatrix)
    {
        char[] firstSeq = subMatrix.getFirstSequenceArray();
        char[] secondSeq = subMatrix.getSecondSequenceArray();
        
        for (int i = 1; i < subMatrix.getNumberOfRows(); i++)
        {
            for (int j = 1; j < subMatrix.getNumberOfColumns(); j++)
            {
                int substitutionScore = comparePair(firstSeq, secondSeq, j - 1, i - 1);
                NeighborPointer up = new NeighborPointer(subMatrix.getScoreMatrixValue(i - 1, j) + m_specificAlgorithm.getGap(), i - 1, j, EDirection.up);
                NeighborPointer left = new NeighborPointer(subMatrix.getScoreMatrixValue(i, j - 1) + m_specificAlgorithm.getGap(), i, j - 1, EDirection.left);
                NeighborPointer diagonal = new NeighborPointer(subMatrix.getScoreMatrixValue(i - 1, j - 1) + substitutionScore, i - 1, j - 1, EDirection.diagonal);                
                NeighborPointer result = m_specificAlgorithm.scoringFunction(up, left, diagonal);
                //System.out.printf("row:%d column:%d up:%d left:%d diagonal:%d result:%d\n", i, j, up.getScore(), left.getScore(), diagonal.getScore(), result.getScore());
                subMatrix.setScore(i, j, result.getScore());
                subMatrix.setTraceBack(i, j, result.getDirection(),new Tuple<>(result.getRow(), result.getColumn()));
            }
        }
    }    
    
    public void traceback(SubstitutionMatrix subMatrix)
    {
        int numberOfSequences = 2;
        int alignmentSize = 0;
        int currentRow = 0;
        int currentColumn = 0;
        int counterFirstSeq = 0;
        int counterSecondSeq = 0;
        int counterAlignment = 0;
        char[][] alignment = null;
        //ArrayList<String> path = new ArrayList<>();
        ArrayList<Tuple<Integer,Integer>> path = new ArrayList<>();
        Tuple<Integer,Integer> startPoint = null;

        
        counterFirstSeq = subMatrix.getFirstSequenceArray().length;
        counterSecondSeq = subMatrix.getSecondSequenceArray().length;
        alignmentSize = Math.max(counterFirstSeq,counterSecondSeq);
        alignment = new char[numberOfSequences][alignmentSize];        

        
        for (char[] row : alignment)
            for (int j = 0; j < row.length; j++)
                row[j] = '-';
            
        startPoint = m_specificAlgorithm.tracebackStartPoint(subMatrix);
        if(startPoint==null)
            throw new Error("Implementation Error. Matrixes doesn't has elements.");
        
        //path.add(String.format("[%d,%d]",startPoint.getFirstElement(),startPoint.getSecondElement()));
        path.add(new Tuple<Integer,Integer>(startPoint.getFirstElement(),startPoint.getSecondElement()));
        currentRow = startPoint.getFirstElement();
        currentColumn = startPoint.getSecondElement();
        counterFirstSeq = currentColumn-1;
        counterSecondSeq = currentRow-1;
        counterAlignment = Math.max(counterFirstSeq, counterSecondSeq);
        do 
        {
            //System.out.printf("row:%d column:%d\n",currentRow,currentColumn);
            //System.out.printf("counterAlignment:%d counterFirst:%d counterSecond:%d\n\n",counterAlignment,counterFirstSeq,counterSecondSeq);
            TracebackCharacter currentPosition = subMatrix.getTraceBackMatrixValue(currentRow,currentColumn);
            int newRow = currentPosition.getRowPointed();
            int newColumn= currentPosition.getColumnPointed();
            switch(currentPosition.getDirection()){
                case diagonal:
                    alignment[0][counterAlignment] = subMatrix.getFirstSequenceArray()[counterFirstSeq];
                    alignment[1][counterAlignment] = subMatrix.getSecondSequenceArray()[counterSecondSeq];
                    counterAlignment--;
                    counterFirstSeq--;
                    counterSecondSeq--;
                    break;
                case up:
                    alignment[1][counterAlignment] = subMatrix.getSecondSequenceArray()[counterSecondSeq];
                    counterAlignment--;
                    counterSecondSeq--;
                    break;                    
                case left:                
                    alignment[0][counterAlignment] = subMatrix.getFirstSequenceArray()[counterFirstSeq];
                    counterAlignment--;
                    counterFirstSeq--;
                    break;                    
                case none:
                    //throw new Error("Implementation Error. Empty direction in the traceback path.");
                    break;
            }
            currentRow = newRow;
            currentColumn = newColumn;
            //path.add(String.format("[%d,%d]",currentRow,currentColumn));
            path.add(new Tuple<Integer,Integer>(currentRow,currentColumn));
        } while (m_specificAlgorithm.tracebackStopCondition(subMatrix,currentRow,currentColumn));                
        m_alignment = alignment;
        m_path = path;
    }
// </editor-fold>
    
}
