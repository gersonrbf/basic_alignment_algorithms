/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

/**
 *Smith-Waterman Algorithm
 *
 *@author Gerson Romano Barbieri Filho
 */
public class LocalAlignmentAlgorithmSpecificity extends AlignmentAlgorithmSpecificity
{    
    @Override
    public int initializationValue(int shift)
    {
        return 0;
    }

    @Override
    public NeighborPointer scoringFunction(NeighborPointer up, NeighborPointer left, NeighborPointer diagonal)//should change to NeighborPointer ... neighbors
    {
        if(up.getScore()==0)
            up.setDirection(EDirection.none);
        if(left.getScore()==0)
            left.setDirection(EDirection.none);
        if(diagonal.getScore()==0)
            diagonal.setDirection(EDirection.none);        
        return NeighborPointer.MaxNeighborPointer(up,left,diagonal,new NeighborPointer(0, -1, -1, EDirection.none));
    }

    @Override
    public Tuple<Integer, Integer> tracebackStartPoint(SubstitutionMatrix subMatrix) {
        return subMatrix.maxScorePosition();
    }    

    @Override
    public boolean tracebackStopCondition(SubstitutionMatrix subMatrix, int currentRow, int currentColumn) {
        return subMatrix.getScoreMatrixValue(currentRow, currentColumn)!=0;
    }

    @Override
    public EDirection rowInitializationDirection() {
        return EDirection.none;
    }

    @Override
    public EDirection columnInitializationDirection() {
        return  EDirection.none;
    }
    
}
