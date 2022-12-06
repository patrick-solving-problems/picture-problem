

@Value
public class Picture {

	@Size(min = 4, max = 4)
	private final List<Picute> subpictues;

	private final PicuteType type;
  
}

public enum PicuteType {

	BLACK, WHITE, SUBPICTURE

}



public static Picute merge(Picute p1, Picture p2) {
		if(p1.getType() == BLACK || p2.getType() == BLACK) {
    	return new Picture(List.of(), BLACK)
    }
    if(p1.getType() == WHITE && p2.getType() == WHITE) {
    	return new Picture(List.of(), WHITE)
    }
    if(p1.getSubpictures() != null && p2.getType() == WHITE) {
    	return p1;
    }
    if(p1.getType() == WHITE && p2.getSubpictures() != null ) {
    	return p2;
    }
    List<Picutes> subpicutes = new ArrayList<>();
    for(int i = 0; i < p1.getSubpicutes().size(); i++) {
    	subpicutes.add(merge(p1.get(i), p2.get(i)))
    }
    return new Picutes(subpicutes, SUBPICTURE);
}


private static Object[][] myParams()
{new Picture(BLACK), new Picute(BLACK), new Picute()},
{new Picture(BLACK), new Picute(BLACK), new Picute()},
{new Picture(BLACK), new Picute(BLACK), new Picute()},
{new Picture(BLACK), new Picute(BLACK), new Picute()},


@ParameterizedTest
@MethodSource("myParams")
void myTest(Picture p1, Picture p2, Picture expected) {
	assertThat(merge(p1, p2)).isEqualTo(expected);
}
