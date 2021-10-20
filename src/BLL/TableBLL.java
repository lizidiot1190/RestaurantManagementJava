
package BLL;

import DAO.ConnectSQLServer;
import DAO.TableDAO;
import DTO.TableDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizid
 */
public class TableBLL {
    
    private ArrayList<TableDTO> listTable;
    
    public TableBLL(){
        listTable = new ArrayList<>();
    }
    
    public ArrayList<TableDTO> getListTable(){
        TableDAO db=new TableDAO();
        listTable=db.GetTableList();
        return this.listTable;
    }
    public void GetListTable(JTable table)
    {
        TableDAO tableDAO = new TableDAO();
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
        TableDAO tableDAO = new TableDAO();
        tableDAO.AddTable(tableName, status);
    }
    public void UpdateTable(String tableName, String status, int id)
    {
        TableDAO tableDAO = new TableDAO();
        tableDAO.UpdateTable(tableName, status, id);
    }
    public void DeleteTable(int id)
    {
        TableDAO tableDAO = new TableDAO();
        tableDAO.DeleteTable(id);
    }
    public void changeTableStatus(int id, String status){
        TableDAO tableDAO= new TableDAO();
        tableDAO.updateTableStatus(id, status);
    }
    
}
