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
public class Basic_alignment_algorithms
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //for (int i = 0; i < args.length; i++)
        //    System.out.printf("args[%d]:%s",i,args[i]);
        
        //launch GUI
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {

                boolean anaLocalAlignment = false;
                String ana = "ana";                
                if(args.length>0&&ana.equalsIgnoreCase(args[0]))
                    anaLocalAlignment = true;
                //System.out.println(anaLocalAlignment);
                new GUIv2(anaLocalAlignment).setVisible(true);
            }
        });
    }
    
}
