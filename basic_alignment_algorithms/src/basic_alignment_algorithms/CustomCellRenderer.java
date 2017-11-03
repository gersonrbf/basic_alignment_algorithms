/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gerson Romano Barbieri Filho
 */
public class CustomCellRenderer extends DefaultTableCellRenderer
{
    private ArrayList<Tuple<Integer,Integer>> m_markedCells = null;
        
    public void setMarkedCells(ArrayList<Tuple<Integer,Integer>> markedCells)
    {
        m_markedCells = markedCells;        
    }    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        //System.out.println("Renderer");
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(m_markedCells==null)
            return c;
        c.setForeground(checkPosition(m_markedCells, row-1, column-1)?Color.red:Color.BLACK);
        return c;
    }
    
    private boolean checkPosition(ArrayList<Tuple<Integer,Integer>> list, int row, int column)
    {
        for (Iterator<Tuple<Integer, Integer>> it = list.iterator(); it.hasNext();) {
            Tuple pair = it.next();
            int first = (int) pair.getFirstElement();
            int second = (int) pair.getSecondElement();
            if(first==row&&second==column)
                return true;
        }
        return false;
    }           
    
    
}
