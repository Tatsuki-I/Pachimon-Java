
public class Type {
	int type;
	String typeName;

	Type(final int TYPE_NUM){
		this.type = TYPE_NUM;
		this.setType(this.type);
	}

	void setType(final int TYPE_NUM){
		switch (TYPE_NUM) {
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
