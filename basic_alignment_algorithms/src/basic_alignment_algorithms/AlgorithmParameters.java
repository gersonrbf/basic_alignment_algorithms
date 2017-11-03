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
public class AlgorithmParameters {

// <editor-fold defaultstate="collapsed" desc=" Private Fields ">
    private int m_match = 0;
    private int m_mismatch = 0;
    private int m_gap = 0;
    private int m_gapExtension = 0;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Constructors ">
    public AlgorithmParameters(int match, int mismatch, int gap, int gapExtension) {
        m_match = match;
        m_mismatch = mismatch;
        m_gap = gap;        
        m_gapExtension = gapExtension;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Get Methods ">
    public int getMatch() {
        return m_match;
    }
    
    public int getMismatch() {
        return m_mismatch;
    }
    
    public int getGap() {
        return m_gap;
    }
    
    public int getGapExtension() {
        return m_gapExtension;
    }
// </editor-fold>
    
}