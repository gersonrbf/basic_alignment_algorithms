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
public class AnaAlignmentAlgorithmSpecificity extends AlignmentAlgorithmSpecificity
{    
    @Override
    public int initializationValue(int shift)
    {
        return 0;
    }

    @Override
    public NeighborPointer scoringFunction(NeighborPointer up, NeighborPointer left, NeighborPointer diagonal)//should change to NeighborPointer ... neighbors
    {
        NeighborPointer temp = NeighborPointer.MaxNeighborPointer(up,left,diagonal);
        return temp.getScore()<0?new NeighborPointer(0, -1, -1, temp.getDirection()):temp;
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
        return EDirection.left;
    }

    @Override
    public EDirection columnInitializationDirection() {
        return  EDirection.up;
    }
    
}