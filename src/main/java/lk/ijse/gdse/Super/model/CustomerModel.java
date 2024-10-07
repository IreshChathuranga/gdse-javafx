package lk.ijse.gdse.Super.model;

import lk.ijse.gdse.Super.db.DBConnection;
import lk.ijse.gdse.Super.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {
    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Select customer_id from customer order by customer_id desc limit 1";
        PreparedStatement pst = connection.prepareStatement(sql);

        ResultSet rst = pst.executeQuery();
        if(rst.next()){
            String lastId = rst.getString(1); //COO1
            String subString = lastId.substring(1); // 002
            int i = Integer.parseInt(subString);//2
            int newIdIndex = i+1;//3
//            String newId = ; //C003
            return String.format("C%03d",newIdIndex);
        }
        return  "C001";

    }
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        Connection connection =  DBConnection.getInstance().getConnection();
        String sql  = "insert into customer values(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setObject(1,customerDto.getCustomerId());
        pst.setObject(2,customerDto.getName());
        pst.setObject(3,customerDto.getNic());
        pst.setObject(4,customerDto.getEmail());
        pst.setObject(5,customerDto.getPhone());

        int result = pst.executeUpdate();
        boolean isSaved = result>0;
        return  isSaved;
    }
}
