package br.com.teste01.JDBC;

import java.util.Scanner;

import br.com.teste01.Tabela01.Tabela01;

public class App 
{
    public static void main( String[] args )
    {
    	Tabela01 tbl01 = new Tabela01();
    	   
    	try {
    		Scanner scn = new Scanner(System.in);    		
    		int opcao = 0;
    		    		    		
    		do {
    			try {    				    		
    				opcao = Integer.parseInt(scn.nextLine());
    			}
    			catch (Exception ex) {
    				System.out.println("ERRO");
    				opcao = -1;
    				continue;
    			}
    			
    			switch (opcao) {
    				case 1:
    					//Incluir registro...
    			    	tbl01.setNome("Teste 01");
    			    	tbl01.setDataNasc("1990-12-18");    	
    			    	tbl01.setIdade(27);
    			    	tbl01.setAltura(1.73);
    			    	tbl01.setPeso(95.5);    	
    			    	tbl01.IncluirRegistro();
    					break;
    					
    				case 2:
    					//Alterar registro...
    			    	tbl01.setId(9);
    			    	tbl01.setNome("Novo nome");
    			    	tbl01.setAltura(1.55);
    			    	tbl01.setPeso(79.854);
    			    	tbl01.AlterarRegistro();
    					break;
    					
    				case 3:
    					//Apagar registro...
    			    	tbl01.setId(7);
    			    	tbl01.ExcluirRegistro();
    					break;
    					
    				case 4:
    					//Mostrar os registros...
    			    	tbl01.MostrarRegistros();
    			    	break;
    			    	
    				case 0:
    					break;
    			    	
    			    default:
    			    	System.out.println("Opção inválida");
    			}
    			
    		} while (opcao != 0);
    		
    		try {    			    	
    			tbl01.getCn().Desconectar();
    		}
    		catch(Exception ex) {
    			
    		}
    		System.out.println("FIM EXECUÇÃO");
    	}    	
    	catch(Exception ex) {
    		
    	}    	
    }
}
