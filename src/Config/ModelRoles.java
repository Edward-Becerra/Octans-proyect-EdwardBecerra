
package Config;

import Entities.Roles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelRoles {
    public ArrayList<Roles> getRoles(){
        Connection con  = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Roles> listRoles = new ArrayList<>();  
        
        try {
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM rol ORDER BY id_rol");
            
            while(rs.next()){
                Roles roles = new Roles();
                roles.setId_rol(rs.getInt("id_rol"));
                roles.setNombre(rs.getString("nombre"));
                listRoles.add(roles);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRoles;             
    }
}
