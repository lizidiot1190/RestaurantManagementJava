
package BLL;

import DAO.BillDAO;
import DAO.ConnectSQLServer;
import DAO.TableDAO;
import DTO.TableDTO;
import GUI.TableGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizid
 */
public class TableBLL {
    
    private ArrayList<TableDTO> listTable;
    protected TableDAO tableDAO;
    protected BillDAO billDAO;
    public TableBLL(){
        listTable = new ArrayList<>();
    }
    
    public ArrayList<TableDTO> getListTable(){
        tableDAO=new TableDAO();
        listTable=tableDAO.GetTableList();
        return this.listTable;
    }
    public void GetListTable(JTable table)
    {
        tableDAO = new TableDAO();
        listTable = tableDAO.GetTableList();
        DefaultTableModel tabletable=(DefaultTableModel)table.getModel();
        tabletable.setRowCount(0);
        Object row[] = new Object[3];
        for(int i = 0; i < listTable.size(); i++)
        {
            row[0]=listTable.get(i).getTableId();
            row[1]=listTable.get(i).getTableName();
            row[2]=listTable.get(i).getTableStatus();
            tabletable.addRow(row);
        }
                
    }
    
    
    public void AddTable(String tableName, String status)
    {
        tableDAO = new TableDAO();
        tableDAO.AddTable(tableName, status);
    }
    public void UpdateTable(String tableName, String status, int id)
    {
        tableDAO = new TableDAO();
        tableDAO.UpdateTable(tableName, status, id);
    }
    public void DeleteTable(int id)
    {
        tableDAO = new TableDAO();
        tableDAO.DeleteTable(id);
    }
    public void changeTableStatus(int id, String status){
        tableDAO= new TableDAO();
        tableDAO.updateTableStatus(id, status);
    }
    
    public ArrayList<String> GetListTableNameNonBill(){
        tableDAO = new TableDAO();
        ArrayList<String> listTableName;
        listTableName=tableDAO.GetTableNameNonBill();
        return listTableName;
    }
    
    public void ChangeTable(String newTable, int oldTable){
        billDAO = new BillDAO();
        if(billDAO.CheckBillStatus(oldTable)==false){
            JOptionPane.showMessageDialog(null, "Bàn này chưa có hóa đơn, không thể chuyển sang bàn khác!");
        }
        else{
            tableDAO =new TableDAO();
            int newTableId = tableDAO.GetTableId(newTable);
            int billId = billDAO.GetBillId(oldTable);
            billDAO.UpdateTableId(billId, newTableId);
            tableDAO.updateTableStatus(newTableId, "Có người");
            tableDAO.updateTableStatus(oldTable, "Trống");
            JOptionPane.showMessageDialog(null, "Chuyển bàn thành công!");
        }
    }
    public void loadTable(JPanel panel){
        tableDAO = new TableDAO();
        listTable=tableDAO.GetTableList();        
        for(int i=0;i<listTable.size();i++){
            String tableName=listTable.get(i).getTableName();
            String tableStatus= listTable.get(i).getTableStatus();
            int tableId = listTable.get(i).getTableId();
            JButton button = new JButton("<html>" + tableName + "<br>" + tableStatus + "</html>");
            button.setBackground(Color.CYAN);
//            button.setForeground(Color.GRAY);
            button.setPreferredSize(new Dimension(175, 175));
            button.setFont(new Font("Arial", Font.BOLD, 18));
            panel.add(button);
            switch(tableStatus){
                case "Trống":
                    button.setBackground(Color.CYAN);
                    break;
                case "Bàn đặt":
                    button.setBackground(Color.RED);
                    break;
                default:
                    button.setBackground(Color.ORANGE);
                    break;
                
            }
            button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    TableGUI tableGUI=new TableGUI(tableName,tableId);
                    tableGUI.setVisible(true);
                    
                }

            });
        }
    }
    
    
}
