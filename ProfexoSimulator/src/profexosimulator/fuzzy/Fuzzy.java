/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profexosimulator.fuzzy;

//package net.sourceforge.jFuzzyLogic.test;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class Fuzzy {
    public void teste() throws Exception {
        // Load from 'FCL' file
        String fileName = "tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show 
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("Qualidade_Time", 1);
        fis.setVariable("Qualidade_Adversario", 10);
        fis.setVariable("Estadio", 7);
        

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable Possibilidade = functionBlock.getVariable("Possibilidade");
        JFuzzyChart.get().chart(Possibilidade, Possibilidade.getDefuzzifier(), true);
        //functionBlock.getVariable("tip").chartDeFuzzifier(true);

        // Print ruleSet
        System.out.println(fis);
    }
}