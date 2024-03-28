
package colombiansoccerleague;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    Match game = new Match();
    ArrayList<Team> lstTeams = game.getLstTeams();
    String[] COLUMNS = {"Name", "W", "L","D","GS","GC","M","Pts"};
    DefaultTableModel tableModel;
    ArrayList<Team> newList;
    int counter = 0;
    
    public Main() {
       initComponents();
       game.initTeamList();
       initObjects();
       
       
    }
    
    private void initObjects() {
        String[][] data = new String[game.getTeamsLstSize()][8];
        for (int i = 0; i < game.getTeamsLstSize(); i++) {
            data[i][0] = lstTeams.get(i).getName();
            data[i][1] = String.valueOf(lstTeams.get(i).getWins());
            data[i][2] = String.valueOf(lstTeams.get(i).getLosses());
            data[i][3] = String.valueOf(lstTeams.get(i).getDraws());
            data[i][4] = String.valueOf(lstTeams.get(i).getGoalsScored());
            data[i][5] = String.valueOf(lstTeams.get(i).getGoalsConceded());
            data[i][6] = String.valueOf(lstTeams.get(i).getMatchesPlayed());
            data[i][7] = String.valueOf(lstTeams.get(i).getPoints());
        }
        tableModel = new DefaultTableModel(data, COLUMNS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblStats.setModel(tableModel);
        tblStats.setAutoCreateRowSorter(true);
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStats = new javax.swing.JTable();
        lblStats = new javax.swing.JLabel();
        lblRecap = new javax.swing.JLabel();
        btnPlayRound = new javax.swing.JButton();
        btnPlayTournament = new javax.swing.JButton();
        btnPlayMatch = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRecap = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Wins", "Losses", "Draws", "GS", "GC", "M", "Points"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStats);

        lblStats.setText("Stats");

        lblRecap.setText("Recap");

        btnPlayRound.setText("Play Round");
        btnPlayRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayRoundActionPerformed(evt);
            }
        });

        btnPlayTournament.setText("Play Tournament");
        btnPlayTournament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayTournamentActionPerformed(evt);
            }
        });

        btnPlayMatch.setText("Play Match");
        btnPlayMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayMatchActionPerformed(evt);
            }
        });

        lblTitle.setText("Soccer For All");

        tblRecap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblRecap);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(102, 102, 102)
                        .addComponent(btnPlayMatch)
                        .addGap(211, 211, 211))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(lblStats))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPlayRound)
                        .addGap(67, 67, 67)
                        .addComponent(btnPlayTournament)
                        .addGap(300, 300, 300))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRecap)
                        .addGap(251, 251, 251))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlayTournament)
                    .addComponent(btnPlayRound)
                    .addComponent(btnPlayMatch)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStats)
                    .addComponent(lblRecap))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(216, 216, 216))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayRoundActionPerformed
        if (counter<=game.getTeamsLstSize()){
            counter += game.getTeamsLstSize()/2; 
            game.playRound();
            //newList = game.playRound();
            //updatedLstStats();
            initObjects();
        }
        else{
            //Poner un alert que diga que ya se acabo
        }
        
        
    }//GEN-LAST:event_btnPlayRoundActionPerformed

    private void btnPlayTournamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayTournamentActionPerformed
        if (counter==0){
            game.playTournament();
            //newList = game.playTournament();
            //updatedLstStats();
            initObjects();
            counter += game.getTeamsLstSize()/2*(game.getTeamsLstSize()-1);
        }
        else{
            //Poner un alert que diga que ya se acabo
        }
    }//GEN-LAST:event_btnPlayTournamentActionPerformed

    private void btnPlayMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayMatchActionPerformed
        if (counter<(game.getTeamsLstSize()/2)*(game.getTeamsLstSize()-1)){
            counter += 1;
            game.playMatch();
            //newList = game.playMatch();
            //updatedLstStats();
            initObjects();
        }
        else{
            //Poner un alert que diga que ya se acabo
        }
    }//GEN-LAST:event_btnPlayMatchActionPerformed

    public void updatedLstStats(){
        String[][] newData = new String[game.getTeamsLstSize()][8];
        for (int i = 0; i < game.getTeamsLstSize(); i++) {
            newData[i][0] = newList.get(i).getName();
            newData[i][1] = String.valueOf(newList.get(i).getWins());
            newData[i][2] = String.valueOf(newList.get(i).getLosses());
            newData[i][3] = String.valueOf(newList.get(i).getDraws());
            newData[i][4] = String.valueOf(newList.get(i).getGoalsScored());
            newData[i][5] = String.valueOf(newList.get(i).getGoalsConceded());
            newData[i][6] = String.valueOf(newList.get(i).getMatchesPlayed());
            newData[i][7] = String.valueOf(newList.get(i).getPoints());
        }
        tableModel.setDataVector(newData, COLUMNS);
        tblStats.setModel(tableModel);
        
        
    }
    
    /*TODO Crear un alert que me muestre el ganador(podemos poner que cuando counter==)
    if(counter==game.getLstSize()/2)*(game.getLstSize()-1) do el alert con el ganador*/
    
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayMatch;
    private javax.swing.JButton btnPlayRound;
    private javax.swing.JButton btnPlayTournament;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblRecap;
    private javax.swing.JLabel lblStats;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRecap;
    private javax.swing.JTable tblStats;
    // End of variables declaration//GEN-END:variables
}
