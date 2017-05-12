
public class Type {
	int type;
	String typeName;

	Type(final int NUM){
		this.setType(NUM);
	}

	void setType(final int NUM){
		this.type = NUM;
		switch (this.type) {
		case 0:
			this.typeName = "ほのお";
			break;
		case 1:
			this.typeName = "みず";
			break;
		case 2:
			this.typeName = "くさ";
			break;
		}
	}
}
