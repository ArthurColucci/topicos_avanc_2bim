package com.reges.spring.rdn;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reges.spring.modelos.livroAluga;

public class livroAlugaRdn {

    public int inserirlivroAluga(livroAluga cli) {

        try {

            int linhasAfetadas = 0;

            StringBuilder str = new StringBuilder();

            str.append("INSERT INTO livro(                ");
            str.append("            titulo                    ");            
            str.append("            ,isbn              ");
            str.append("            ,cartaofidelidade       ");
            str.append("            ,autor               ");
            str.append("            ,genero                  ");
            str.append("            ,nPaginas                  ");
            str.append("            ,ano                  ");
            str.append("            ,tipo)                  ");
            str.append("      VALUES(                       ");
            str.append("             ?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                      ");            
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                      ");
            str.append("            ,?                  ");
            str.append("         )                          ");                                              
           
            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();

            
            //CRIA O STATMENT JÁ PREPARADO PARA OBTER O ID aluguel GERADO
            PreparedStatement stmt = conn.prepareStatement(str.toString(), Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cli.geTItulo());            
            stmt.setString(2, cli.getIsbn());
            stmt.setString(3, cli.getCartaoFidelidade());
            stmt.setString(4, cli.getAutor());
            stmt.setString(5, cli.getGenero());
            stmt.setString(6, cli.getNPaginas());
            stmt.setString(7, cli.getAno());
            stmt.setInt(6, 1);
                  
            int id = 0;
            
            linhasAfetadas =stmt.executeUpdate();      
            
            ResultSet rs = stmt.getGeneratedKeys();            
            if (rs.next()) {
                //RECUPERA O IDLIVROALUGA
                
               id = rs.getInt(1); //recuperar o id               
               
            //    EnderecoRdn endRdn = new EnderecoRdn();           
            //    Endereco end = cli.getEndereco();
            //    end.setIdPessoa(id);
               
            //    endRdn.inserirEndereco(end);
               
            }                                                

            //LIBERAR OS RECURSOS
            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            return 0;
        }
    }

    public int alterarlivroAluga(livroAluga cli) {

        try {
            int linhasAfetadas = 0;
            StringBuilder str = new StringBuilder();

            str.append("UPDATE livro SET TITULO 			        = ?         ");            
            str.append("                  ,ISBN		     = ?        ");
            str.append("                 ,AUTOR               = ?        ");
            str.append("                 ,GENERO 		         = ?        ");
            str.append("                 ,CARTAOFIDELIDADE	     = ?        ");
            str.append("WHERE	ID                               = ?        ");

            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());

            stmt.setString(1, cli.geTItulo());            
            stmt.setString(2, cli.getIsbn());
            stmt.setString(3, cli.getAutor());
            stmt.setString(4, cli.getGenero());
            stmt.setString(5, cli.getCartaoFidelidade());            
            stmt.setInt(6, cli.getId());

            linhasAfetadas = stmt.executeUpdate();

            
            // EnderecoRdn endRdn = new EnderecoRdn();            
            // endRdn.alterarEndereco(cli.getEndereco());
            
            //LIBERAR OS RECURSOS
            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex.getMessage());
            return 0;
        }

    }

    public int deletarlivroAluga(int idlivroAluga) {
        try {

            //REMOVER ENDERECO
            // EnderecoRdn endRdn = new EnderecoRdn();
            // endRdn.deletarEnderecoPorPessoa(idCliente);

            int linhasAfetadas = 0;

            String str = "DELETE FROM LIVRO WHERE ID = ?";
            ConnectionFactory factory = new ConnectionFactory();
            Connection conn = factory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());
            stmt.setInt(1, idlivroAluga);

            linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            return 0;
        }

    }

    public List<livroAluga> obterTodos() {
        try {

            List<livroAluga> lstCli = new ArrayList<livroAluga>();

            StringBuilder str = new StringBuilder();

            str.append("SELECT  ID               ");
            str.append("     ,TITULO               ");       
            str.append("     ,ISBN         ");
            str.append("     ,AUTOR           ");
            str.append("     ,GENERO              ");
            str.append("     ,CARTAOFIDELIDADE   ");
            str.append("FROM LIVRO              ");
            str.append(" WHERE TIPO = 1           ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT            
            Statement stmt = conn.createStatement();

            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery(str.toString());

            // //INSTANCIA DA CLASSE ENDERECO RDN
            //  EnderecoRdn endRdn = new EnderecoRdn();
             
            while (rs.next()) {

                //CONVERTER SQL DATE TO CALENDAR
               /* Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("DATANASCIMENTO"));*/

                /*              
                public Cliente(int id, String nome, Calendar dataNascimento, String documento, 
                String telefone, String email, Endereco endereco, String cartaoFidelidade)
                 */
               
            //   Endereco end = endRdn.obterPorIdLivro(rs.getInt("ID"));                
              
              

            }
            return lstCli;

        } catch (SQLException ex) {

            System.out.println("ERRO:" + ex.getMessage());
            return null;
        }
    }
    
    public livroAluga obterPorId(int id) {
        try {

            livroAluga ret = null;

            StringBuilder str = new StringBuilder();

            str.append("SELECT  ID               ");
            str.append("     ,TITULO               ");
           // str.append("     ,DATANASCIMENTO     ");
            str.append("     ,CARTAOFIDELIDADE   ");
            str.append("     ,ISBN          ");
            str.append("     ,AUTOR           ");
            str.append("     ,GENERO              ");
            str.append("FROM LIVRO              ");
            str.append(" WHERE TIPO = 1          ");
            str.append(" AND ID      = ?         ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT            
            PreparedStatement stmt = conn.prepareStatement(str.toString());

          
            stmt.setInt(1, id);
            
            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery();

            // //INSTANCIA DA CLASSE ENDERECO RDN
            // EnderecoRdn endRdn = new EnderecoRdn();
            
            if (rs.next()) {

                //CONVERTER SQL DATE TO CALENDAR
                //Calendar calendar = Calendar.getInstance();
                //calendar.setTime(rs.getDate("DATANASCIMENTO"));

                /*              
                public Cliente(int id, String nome, Calendar dataNascimento, String documento, 
                String telefone, String email, Endereco endereco, String cartaoFidelidade)
                 */
                // Endereco end = endRdn.obterPorIdPessoa(rs.getInt("ID"));
                
                
            }
            return ret;

        } catch (SQLException ex) {

            System.out.println("ERRO:" + ex.getMessage());
            return null;
        }
    }

}