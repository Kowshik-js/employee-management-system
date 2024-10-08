package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeEmployee extends JFrame {

    Choice choiceEMPID;
    JButton delete, back;
    JLabel textName, textPhone, textEmail; // Declare text fields at the class level

    removeEmployee() {
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200, 50, 250, 30);
        choiceEMPID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                loadEmployeeDetails(choiceEMPID.getSelectedItem());
            }
        });
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        textName = new JLabel();
        textName.setBounds(200, 100, 200, 30); // Adjusted bounds for clarity
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelPhone);

        textPhone = new JLabel();
        textPhone.setBounds(200, 150, 200, 30); // Adjusted bounds for clarity
        add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelEmail);

        textEmail = new JLabel();
        textEmail.setBounds(200, 200, 200, 30); // Adjusted bounds for clarity
        add(textEmail);

        // Load initial employee details for the first item in the choice
        if (choiceEMPID.getItemCount() > 0) {
            loadEmployeeDetails(choiceEMPID.getItem(0));
        }

        // Create Delete button
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 160, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white); // Corrected 'ForeGround' to 'Foreground'
        add(delete);

        // Create Back button
        back = new JButton("Back");
        back.setBounds(300, 300, 160, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white); // Corrected 'ForeGround' to 'Foreground'
        add(back);

        // Action Listener for Delete button
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteEmployee(choiceEMPID.getSelectedItem());
            }
        });

        // Action Listener for Back button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main_class(); // Assuming Main_class is your main menu or previous window
            }
        });

        // Add delete icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 150, 200, 200); // Adjust the position as needed
        add(img);

        setSize(1000, 400);
        setLocation(300, 150);
        setLayout(null);
        setVisible(true);
    }

    private void loadEmployeeDetails(String empID) {
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee WHERE empid='" + empID + "'");
            if (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            } else {
                textName.setText("");
                textPhone.setText("");
                textEmail.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(String empID) {
        try {
            conn c = new conn();
            String query = "DELETE FROM employee WHERE empid='" + empID + "'";
            int result = c.statement.executeUpdate(query);
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Employee deleted successfully");
                choiceEMPID.remove(empID); // Remove the deleted employee from the choice
                if (choiceEMPID.getItemCount() > 0) {
                    loadEmployeeDetails(choiceEMPID.getItem(0)); // Load details for the next employee
                } else {
                    // If no more employees, clear the fields
                    textName.setText("");
                    textPhone.setText("");
                    textEmail.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete employee");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new removeEmployee();
    }
}
