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
public class NeighborPointer {

    private int m_score = 0;
    private int m_rowOfNeighbor = 0;
    private int m_columnOfNeighbor = 0;
    private EDirection m_direction = null;

    
    
    public NeighborPointer(int score, int rowOfNeighbor, int columnOfNeighbor, EDirection direction)
    {
        m_score = score;
        m_rowOfNeighbor = rowOfNeighbor;
        m_columnOfNeighbor = columnOfNeighbor;
        m_direction = direction;
    }

// <editor-fold defaultstate="collapsed" desc=" Get Methods ">
    public int getScore() {
        return m_score;
    }
    
    public EDirection getDirection() {
        return m_direction;
    }
    
    public int getRow() {
        return m_rowOfNeighbor;
    }
    
    public int getColumn() {
        return m_columnOfNeighbor;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Set Methods ">
    public void setDirection(EDirection direction) {
        m_direction = direction;
    }
// </editor-fold>
    
    public static NeighborPointer MaxNeighborPointer(NeighborPointer reference, NeighborPointer ... neighbors)
    {
        NeighborPointer result = reference;
        for (NeighborPointer neighbor: neighbors)
        {
            
            if(
                    (neighbor.getScore()>result.getScore())||
                    ((neighbor.getScore()==result.getScore())&&(neighbor.getDirection()==EDirection.diagonal))
              )
                result = neighbor;                
        }
        return result;
    }


    
}
