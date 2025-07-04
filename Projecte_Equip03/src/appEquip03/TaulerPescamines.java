package appEquip03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class TaulerPescamines extends ContextPescamines implements Serializable {
    private static final long serialVersionUID = 1L;

	
	Random alea = new Random();
// Fer Random un atribut però transient
	private int l;
	private int a;
	private CasellaPescamines[][] caselles;
	

	private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            
            oos.writeInt(l);
            oos.writeInt(a);
            oos.writeObject(caselles);
		} catch (IOException e) {
		}
    }
    
    private void readObject(ObjectInputStream ois) {
    	try {
            ois.defaultReadObject();
            this.alea = new Random();
            this.l = ois.readInt();
            this.a = ois.readInt();
            this.caselles = (CasellaPescamines[][]) ois.readObject();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
    }

	
	public TaulerPescamines() {
	};
	
	public TaulerPescamines(int l, int a) {
		super();
		this.l = l;
		this.a = a;
		caselles = new CasellaPescamines[this.a][this.l];
		// caselles = Context.assignarMines(caselles, a, alea, "n");
	}

	// GETTERS I SETTERS
	public CasellaPescamines[][] getCaselles() {
		return caselles;
	}

	public void setCaselles(CasellaPescamines[][] caselles) {
		this.caselles = caselles;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
    
	// MÈTODES

}
