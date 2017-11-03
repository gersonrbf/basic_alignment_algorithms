/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_alignment_algorithms;

/**
 *
 * @author gerson
 */
public class TracebackCharacter {

    private EDirection m_character=EDirection.none;
    private Tuple<Integer,Integer> m_pointer = new Tuple<>();
    
    public TracebackCharacter(EDirection character, Tuple<Integer,Integer> pointer)
    {
        m_character = character;
        m_pointer = pointer;
    }
    
    public EDirection getDirection()
    {
        return m_character;
    }
    
    public int getRowPointed()
    {
        return m_pointer.getFirstElement();
    }
    
    public int getColumnPointed()
    {
        return m_pointer.getSecondElement();
    }
    
    public char getCharacterSymbol()
    {
        char character = ' ';
        
        if(m_character!=null)
            switch (m_character) {
            case diagonal:
                character = '\u2196';
                break;
            case left:
                character = '\u2190';
                break;
            case up:
                character = '\u2191';
                break;
            default:
                character = '0';
                break;
        }

        return character;
    }

    void setCharacter(EDirection value, Tuple<Integer,Integer> pointer)
    {
        this.m_character = value;
        this.m_pointer = pointer;
    }
    
}
