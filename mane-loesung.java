Hallo hier ist patrick.

enum PictureType {
	MULTI, WHITE, BLACK
}

class Picture {
	Picture[] pictures
  
  private PictureType type;
  
  public Picture(Picture[] pictures) {
  	pictures = new[4];
    this.type = MULTI;
  }
  
  public Picture(PictureType type) {
  	if(type == PictureType.MULTI)
    	//fehler
  	this.type = type;
  }
  
  public Picture(Picture copy) {
  	// TODO
  }
  
  public Picture combine(Picture other) {
  	if(this.type == BLACK || other.type == BLACK) {
    	return new Picture(BLACK);
    } else if (this.isMulit() && !other.isMulti()) {
    	return new Picture(this);
    } else if (other.isMulti() && !this.isMulti()) {
    	return new Picture(other);
    } else if (this.isMulti() & other.isMulti()) {
    	Picture[] combined = new Picture[4];
      for (int i = 0; i < 4; ++i) {
      	combined[i] = this.pictures[i].combine(other.pictures[i]);
      }
      return new Picture(combined);
    }
    
    return new Picture(WHITE);
  }
  
  public PictureType isMulti() {
  	return type == MULIT;
  }
}
