/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

/**
 *
 * @author Gerson Romano Barbieri Filho
 */
public class SubstitutionMatrix
{
    
// <editor-fold defaultstate="collapsed" desc=" Private Fields ">
    private char[] m_firstSequence = null;
    private char[] m_secondSequence = null;
    private TracebackCharacter[][] m_tracebackMatrix = null;
    private int[][] m_scoreMatrix = null;
    private int m_rows = 0;
    private int m_columns = 0;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Constructors ">
    public SubstitutionMatrix(char[] firstSequence, char[] secondSequence) {
        m_firstSequence = firstSequence;
        m_secondSequence = secondSequence;
    }
    
    public SubstitutionMatrix(String firstSequence, String secondSequence) {
        m_firstSequence = firstSequence.toCharArray();
        m_secondSequence = secondSequence.toCharArray();
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Set Methods ">
    public void setScore(int row, int column, int value)
    {
        m_scoreMatrix[row][column]=value;
    }
    
    public void setTraceBack(int row, int column, TracebackCharacter value)
    {
        m_tracebackMatrix[row][column]=value;
    }
    
    public void setTraceBack(int row, int column, EDirection value, Tuple<Integer,Integer> pointer)
    {
        m_tracebackMatrix[row][column].setCharacter(value,pointer);
    }
    
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Get Methods ">
    public int getNumberOfRows() {
        return m_rows;
    }
    
    public int getNumberOfColumns()
    {
        return m_columns;
    }
    
    public int[][] getScoreMatrix()
    {
       return m_scoreMatrix; 
    }
    
    public TracebackCharacter[][] getTracebackMatrix()
    {
        return m_tracebackMatrix;
    }
    
    public char[] getFirstSequenceArray() {
        return m_firstSequence;
    }

    public char[] getSecondSequenceArray() {
        return m_secondSequence;
    }
    
    public int getScoreMatrixValue(int row, int column) 
    {
        return m_scoreMatrix[row][column];
    }
    
    public TracebackCharacter getTraceBackMatrixValue(int row, int column)
    {
        return m_tracebackMatrix[row][column];
    }
    
    public TracebackCharacter getPointer(int row, int column)
    {
        return m_tracebackMatrix[row][column];
    }    
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Public Methods ">
    public void AllocateMatrixes() {
        int rows = m_secondSequence.length + 1;
        int columns = m_firstSequence.length + 1;
        m_scoreMatrix = new int[rows][columns];
        m_tracebackMatrix = new TracebackCharacter[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m_scoreMatrix[i][j] = 0;
                m_tracebackMatrix[i][j] = new TracebackCharacter(EDirection.none,new Tuple<Integer,Integer>(0,0));
            }
        }
        m_rows = rows;
        m_columns = columns;
    }
    
    public Tuple<Integer, Integer> maxScorePosition()
    {        
        int max = 0;
        int row = 0;
        int column = 0;
        
        if(m_rows>0&&m_columns>0)//this shouldn't be a problem because matrixes are created with lenght+1
           max = m_scoreMatrix[0][0];
        else
            return null;
        
        for (int i = 0; i < m_scoreMatrix.length; i++) 
            for (int j = 0; j < m_scoreMatrix[i].length; j++)
                if(m_scoreMatrix[i][j]>max)
                {
                    max = m_scoreMatrix[i][j];
                    row = i;
                    column = j;
                }
        
        return new Tuple<Integer,Integer>(row, column);       
    }
// </editor-fold>
        
}
