package com.leonet.app.model.problems;

import com.leonet.app.model.databaseConection.QueriesSQL;
import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.model.problems.itemsListProblem.ProblemList;
import com.leonet.app.model.user.UserRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Problems extends QueriesSQL {

    private ProblemList problemList;

    public Problems(BasicDataSource basicDataSource) {
        super(basicDataSource);
    }

    public ProblemList chooseProblemList(String username) {
        String context = "";
        String example = "";
        String statement = "";
        String problem = "";
        String indentation = "";
        int lineContext = 25;
        int lineExample = 25;
        int lineDefProblem = 25;
        int rewardCoin = 0;
        double percentageCompletion = 0;

        ResultSet rs = null;
        Connection connection = null;
        String query = "select context, " +
                "       example, " +
                "       lines_context, " +
                "       lines_example, " +
                "       percentage_completion, " +
                "       reward_coin, " +
                "       p.statement, " +
                "       p.problem, " +
                "       p.lines_problem, " +
                "       p.indentation " +
                "from theme " +
                "join problem p on p.id = theme.problem " +
                "join UserxTheme UT on theme.id = UT.theme " +
                "join userProfile uP on UT.userProfile = uP.nickname " +
                "where uP.nickname = LOWER('" + username + "'); ";
        try {
            connection = basicDataSource.getConnection();
            rs = query(query, connection);
            UserRepository userProfile = null;
            try {
                while (rs.next()) {
                    context = rs.getString(1);
                    example = rs.getString(2);
                    lineContext *= rs.getInt(3);
                    lineExample *= rs.getInt(4);
                    percentageCompletion = rs.getFloat(5);
                    rewardCoin = rs.getInt(6);
                    statement = rs.getString(7);
                    problem = rs.getString(8);
                    lineDefProblem *= rs.getInt(9);
                    indentation = rs.getString(10);
                }
            } catch (SQLException ex) {
                System.out.println("err 57 Problem");
            }
        } catch (SQLException ex) {
            return null;
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }

        ArrayList<ItemList> itemListsArray = createItemsList(problem);
        ArrayList<Integer> indentationArray = defIndentation(indentation);
        problemList = new ProblemList(
                context,
                example,
                statement,
                rewardCoin,
                percentageCompletion,
                lineContext,
                lineExample,
                lineDefProblem,
                itemListsArray,
                indentationArray
        );
        return problemList;
    }

    public ProblemList chooseProblemCode(String username) {
        String context = "";
        String example = "";
        String statement = "";
        String problem = "";
        String indentation = "";
        int lineContext = 25;
        int lineExample = 25;
        int lineDefProblem = 25;
        int rewardCoin = 0;
        double percentageCompletion = 0;

        ResultSet rs = null;
        Connection connection = null;
        String query = "select context, " +
                "       example, " +
                "       lines_context, " +
                "       lines_example, " +
                "       percentage_completion, " +
                "       reward_coin, " +
                "       p.statement, " +
                "       p.problem, " +
                "       p.lines_problem, " +
                "       p.indentation " +
                "from theme " +
                "join problem p on p.id = theme.problem " +
                "join UserxTheme UT on theme.id = UT.theme " +
                "join userProfile uP on UT.userProfile = uP.nickname " +
                "where uP.nickname = LOWER('" + username + "'); ";
        try {
            connection = basicDataSource.getConnection();
            rs = query(query, connection);
            UserRepository userProfile = null;
            try {
                while (rs.next()) {
                    context = rs.getString(1);
                    example = rs.getString(2);
                    lineContext *= rs.getInt(3);
                    lineExample *= rs.getInt(4);
                    percentageCompletion = rs.getFloat(5);
                    rewardCoin = rs.getInt(6);
                    statement = rs.getString(7);
                    problem = rs.getString(8);
                    lineDefProblem *= rs.getInt(9);
                    indentation = rs.getString(10);
                }
            } catch (SQLException ex) {
                System.out.println("err 57 Problem");
            }
        } catch (SQLException ex) {
            return null;
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }

        // ArrayList<ItemList> itemListsArray = createItemsList(problem);
        //ArrayList<Integer> indentationArray = defIndentation(indentation);
        problemList = new ProblemList(
                context,
                example,
                statement,
                rewardCoin,
                percentageCompletion,
                lineContext,
                lineExample,
                lineDefProblem,
                null,
                null
        );
        return problemList;
    }


    public float getPercentageCompletion(String nickname){
        int percentageCompletion = -1;
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            String query = "select percentage_completion " +
                    "from theme " +
                    "join UserxTheme UT on theme.id = UT.theme " +
                    "join userProfile uP on uP.nickname = UT.userProfile " +
                    "where uP.nickname = lower('" + nickname + "');";
            ResultSet rs = query(query, connection);
            if (rs != null) {
                rs.next();
                return rs.getFloat("percentage_completion");
            }
            return -1;
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return -1;
    }

    public int getCountSubThemes(String nickname){
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            String query = "select count(*) " +
                    "from theme " +
                    "         join theme_category tc on theme.theme_category = tc.id " +
                    "where tc.id = (select tc.id " +
                    "               from theme_category as tc " +
                    "                        join theme t on tc.id = t.theme_category " +
                    "                        join UserxTheme UT on t.id = UT.theme " +
                    "                        join userProfile uP on uP.nickname = UT.userProfile " +
                    "               where uP.nickname = lower('" + nickname + "'));";
            //System.out.println("count");
            ResultSet rs = query(query, connection);
            if (rs != null) {
                rs.next();
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return -1;
    }

    public int getAmountProblemSolved(String nickname){
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            String query = "select indexTheme " +
                    "from theme " +
                    "    join UserxTheme UT on theme.id = UT.theme " +
                    "    join userProfile uP on uP.nickname = UT.userProfile " +
                    "where uP.nickname = lower('" + nickname + "');";
            //System.out.println("amout");
            ResultSet rs = query(query, connection);
            if (rs != null) {
                rs.next();
                return rs.getInt(1) - 1;
            }
            return -1;
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return -1;
    }

    public String[] getThemeCategoryInfo(String nickname){
        Connection connection = null;
        try {
            String[] themeCategory = new String[2];
            connection = basicDataSource.getConnection();
            String query = "select levelCategory, typeCategory " +
                    "from theme_category " +
                    "join theme t on theme_category.id = t.theme_category " +
                    "join UserxTheme UT on t.id = UT.theme " +
                    "join userProfile uP on uP.nickname = UT.userProfile " +
                    "where uP.nickname = lower('" + nickname + "')";
            //System.out.println("count");
            ResultSet rs = query(query, connection);
            if (rs != null) {
                rs.next();
                themeCategory[0] =  rs.getString(1);
                themeCategory[1] =  rs.getString(2);
                return themeCategory;
            }
            return null;
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return null;
    }

    private ArrayList<Integer> defIndentation(String indentationSrt) {
        ArrayList<Integer> indentation = new ArrayList<>();
        String[] in = indentationSrt.split(",");
        for (int i = 0; i < in.length; i++) {
            indentation.add(Integer.parseInt(in[i]));
        }
        return indentation;
    }

    private ArrayList<ItemList> createItemsList(String problem) {
        ArrayList<ItemList> itemListsArray = new ArrayList<>();
        String[] items = problem.split("\\*\\*\\*");
        for (int i = 0; i < items.length; i++) {
            // System.out.println("i =" +items[i]);
            itemListsArray.add(createItem(items[i]));
        }
        return itemListsArray;
    }

    private ItemList createItem(String itemList) {
        String[] item = itemList.split("\\*\\*");
        // System.out.println("item = "+item[0]);
        return new ItemList(Integer.parseInt(item[0]), item[1]);
    }

    public String getTypeProblem(String username) {
        String query = "select type from type_problem " +
                "join problem p on type_problem.id = p.type_problem " +
                "join theme t on p.id = t.problem " +
                "join UserxTheme UT on t.id = UT.theme " +
                "join userProfile uP on UT.userProfile = uP.nickname " +
                "where uP.nickname = LOWER('" + username + "') ";

        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            ResultSet rs = query(query, connection);
            if (rs != null) {
                rs.next();
                // System.out.println("type "+rs.getString("type") );
                return rs.getString("type");
            }
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return "";
    }

    public ProblemList getProblemList() {
        return problemList;
    }
}
