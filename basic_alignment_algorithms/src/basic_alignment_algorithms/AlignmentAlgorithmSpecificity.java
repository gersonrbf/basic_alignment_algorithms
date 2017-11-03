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
public abstract class AlignmentAlgorithmSpecificity
{
    
// <editor-fold defaultstate="collapsed" desc=" Private Fields ">
    private AlgorithmParameters m_parameters = null;
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Get Methods ">
    public AlgorithmParameters getParameters()
    {
        return m_parameters;
    }

    public int getMatch() {
        return m_parameters.getMatch();
    }

    public int getMismatch() {
        return m_parameters.getMismatch();
    }
    
    public int getGap() {
        return m_parameters.getGap();
    }
    
    public int getGapExtension() {
        return m_parameters.getGapExtension();
    }
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=" Set Methods ">
    public void setParameters(AlgorithmParameters parameters) {
        m_parameters = parameters;        
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Abstract Methods ">
    public abstract int initializationValue(int shift);
    public abstract NeighborPointer scoringFunction(NeighborPointer up, NeighborPointer left, NeighborPointer diagonal);
    public abstract Tuple<Integer,Integer> tracebackStartPoint(SubstitutionMatrix subMatrix);
    public abstract boolean tracebackStopCondition(SubstitutionMatrix subMatrix, int currentRow, int currentColumn);
    public abstract EDirection rowInitializationDirection();
    public abstract EDirection columnInitializationDirection();
// </editor-fold>    
}
