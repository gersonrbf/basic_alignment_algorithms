/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

/**
 * Needleman-Wunsch Algorithm
 * 
 * @author Gerson Romano Barbieri Filho
 */
public class GlobalAlignmentAlgorithmSpecificity extends AlignmentAlgorithmSpecificity
{    
    @Override
    public int initializationValue(int shift)
    {
        return getGap()*shift;
    }   

    @Override
    public NeighborPointer scoringFunction(NeighborPointer up, NeighborPointer left, NeighborPointer diagonal)
    {
        return NeighborPointer.MaxNeighborPointer(up, left, diagonal);
    }

    @Override
    public Tuple<Integer,Integer> tracebackStartPoint(SubstitutionMatrix subMatrix)
    {
        return new Tuple<Integer,Integer>(subMatrix.getNumberOfRows()-1, subMatrix.getNumberOfColumns()-1);
    }

    @Override
    public boolean tracebackStopCondition(SubstitutionMatrix subMatrix, int currentRow, int currentColumn)
    {
        return !((currentRow==0)&&(currentRow==currentColumn));
    }

    @Override
    public EDirection rowInitializationDirection() 
    {
        return EDirection.left;
    }

    @Override
    public EDirection columnInitializationDirection()
    {
        return EDirection.up;
    }

    
    
}
