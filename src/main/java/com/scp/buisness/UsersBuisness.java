package com.scp.buisness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.scp.entity.Users;
import com.scp.hibernateUtil.HibernateUtil;
import com.scp.hibernateUtil.VerifyUser;
import com.scp.servicesImplimentation.ServicesImplementations;

public class UsersBuisness {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ServicesImplementations s1=new ServicesImplementations();
		System.out.println("R you a authinticated User:(y/n) ");
		String option=br.readLine();
		if(option.equalsIgnoreCase("y")) 
		{
		
			System.out.println("Verification System......");
    		System.out.println("Enter User name:");
    		String uname1=br.readLine();
    		System.out.println("Enter Password:");
    		String pwdnew=br.readLine();
    		
    		if(VerifyUser.authenticateUser(uname1,pwdnew))
    		{
    			while(true)
				{
					System.out.println("Enter your Option:(1.UpdateUser 2.DeleteUser 3.getAllUSers 4.GetUserbyId 5.GetUserbyName 6.exit");
					int opt=Integer.parseInt(br.readLine());
					switch(opt)
					{
						
			            
				    	case 1:
				    		System.out.println("Enter Your Id(Your id should be same)");
				    		int uid=Integer.parseInt(br.readLine());
				    		Users olduser=s1.getUserbyId(uid);
				    		System.out.println("Enter Updated User name:");
				    		String ustr=br.readLine();
				    		olduser.setUsername(ustr);
				    		System.out.println("Enter your new Password:");
				    		String newpwd=br.readLine();
				    		olduser.setPassword(newpwd);
				    		s1.updateUSer(olduser);
				    		break;
				    	case 2:
				    		System.out.println("Enter id of user you want to delete:");
				    		int opt1=Integer.parseInt(br.readLine());
				    		s1.deleteUser(opt1);
				    		System.out.println("Deleted successfully");
				    		break;
				    		
				    	case 3:
				    		System.out.println("List of Users :");
				    		List<Users>list=s1.getAllUsers();
				    		System.out.println(list);
				    		break;
				            
				    	case 4:
				    		System.out.println("Enter Id of user/s you want :");
				    		int id2=Integer.parseInt(br.readLine());
				    		Users user=s1.getUserbyId(id2);
				    		System.out.println(user);
				    		break;
				    		
				    	case 5:
				    		System.out.println("Enter name of user/s you want :");
				    		String name=br.readLine();
				    		List<Users>l=s1.getUserbyName(name);
				    		System.out.println(l);
				    		break;
				    		
				    
				    	case 6:
				    		System.out.println("See you soon..");
				    		System.exit(0);
				    	default:
				    		System.out.println("You can still select other option :");
				    		continue;
				}  		
			}
    		}
    		else 
    		{
				System.out.println("User Id and Password incorrect...");
				System.exit(0);
			}
		
		}
		else {
				if(option.equalsIgnoreCase("n"))
				{
					System.out.println("Create account :");
					System.out.println("Enter Id:");
            		int id=Integer.parseInt(br.readLine());
            		System.out.println("Enter UserName:");
            		String uname=br.readLine();
		            System.out.println("Enter Your Password :");
		            String pwd=br.readLine();
		            Users u1=new Users(id,uname,pwd);
		            s1.addUser(u1);
		            System.out.println("successfully added");
		            System.exit(0);
				}
			}
	
	}

}
