package hw2;

public class Member {
	    String _id, _pw, _fn, _ln, _email;
	    
	    public Member() {
	        _id = "";
	        _pw = "";
	        _fn = "";
	        _ln = "";
	        _email = "";
	    }
	    
	     public void setID(String nID) {
	           _id = nID;
	     }
	        
	     public String getID() {
	          return _id;
	     }
	     
	     public void setPW(String nPW) {
	            _pw = nPW;
	     }
	        
	     public String getPW() {
	          return _pw;
	     }
	     
	     public void setFN(String nFN) {
	            _fn = nFN; 
	     }
	        
	     public String getFN() {
	            return _fn;
	     }
	     
	     public void setLN(String nLN) {
	            _ln = nLN;
	     }
	        
	     public String getLN() {
	            return _ln;
	     }
	     
	     public void setE(String nE) { 
	            _email = nE; 
	     }
	        
	     public String getE() { 
	            return _email; 
	     }
	}