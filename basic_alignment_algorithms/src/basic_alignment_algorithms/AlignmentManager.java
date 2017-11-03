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
public class AlignmentManager
{

// <editor-fold defaultstate="collapsed" desc=" Private Fields ">
    private AlignmentAlgorithm m_algorithm = null;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Constructors ">
// </editor-fold>
    
    
    
    public SubstitutionMatrix executeAlignment(String firstSequence, String secondSequence,
            int match, int mismatch, int gap, int gapExtension,EAlignmentType alignType)
    {
        SubstitutionMatrix subMatrix = generateSubstitutionMatrix(firstSequence,secondSequence);
        m_algorithm = chooseAlgorithm(alignType);
        executeAlgorithm(m_algorithm, subMatrix, match, mismatch, gap, gapExtension);
        return subMatrix;
    }    
   
    private SubstitutionMatrix generateSubstitutionMatrix(String firstSequence, String secondSequence)   
    {
        SubstitutionMatrix subMatrix = new SubstitutionMatrix(firstSequence, secondSequence);
        subMatrix.AllocateMatrixes();
        return subMatrix;
    }
    
        
    private AlignmentAlgorithm chooseAlgorithm(EAlignmentType alignType)
    {
            
        AlignmentAlgorithm agc = new AlignmentAlgorithm();
        AlignmentAlgorithmSpecificity algorithm = null;

        if(alignType==null||alignType==EAlignmentType.None)
            throw new Error("Implementation Problem.There isn't a type in algorithm choice.");
            
        switch (alignType)
        {
            case Ana:
                algorithm = new AnaAlignmentAlgorithmSpecificity();
                break;
            case Local:
                algorithm = new LocalAlignmentAlgorithmSpecificity();
                break;
            case Global:
                algorithm = new GlobalAlignmentAlgorithmSpecificity();
                break;
        }            
        
        agc.setAlgorithmsSpecificity(algorithm);
        
        return  agc;
    }
    
    private void executeAlgorithm(AlignmentAlgorithm algorithm, SubstitutionMatrix subMatrix, int match, int mismatch, int gap, int gapExtension)
    {      
        algorithm.setParamenters(match, mismatch, gap, gapExtension);
        algorithm.initialization(subMatrix);
        algorithm.filling(subMatrix);
        algorithm.traceback(subMatrix);
    }

    public char[][] getAlignment() {
        return m_algorithm.getAlignment();
    }

    public ArrayList<Tuple<Integer,Integer>> getPath() {
        return m_algorithm.getPath();
    }
        
}
