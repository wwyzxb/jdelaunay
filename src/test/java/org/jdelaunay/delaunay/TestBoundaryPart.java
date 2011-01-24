
package org.jdelaunay.delaunay;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides tests that run on the BoundaryPart class.
 * @author alexis
 */
public class TestBoundaryPart extends BaseUtility {

	/**
	 * test if a boundary part can bee right next another one in the boundary.
	 */
	public void testCanBeNext(){
		BoundaryPart bp1 = new BoundaryPart(new Edge(0,0,0,2,2,0));
		List<Edge> be = new ArrayList<Edge>();
		be.add(new Edge(0,0,0,1,4,0));
		bp1.setBoundaryEdges(be);
		BoundaryPart bp2 = new BoundaryPart(new Edge(1,4,0,2,2,0));
		assertTrue(bp1.canBeNext(bp2));
		bp2 = new BoundaryPart(new Edge(8,4,0,2,2,0));
		assertFalse(bp1.canBeNext(bp2));
		bp2 = new BoundaryPart(new Edge(0,0,0,2,2,0));
		assertFalse(bp1.canBeNext(bp2));
	}

        /**
         * tests that we  are able to connect a single point to a bassic boundary part.
         */
        public void testConnectSinglePoint() throws DelaunayError{
                //First we fill an empty boundary part
                List<Edge> bps = new ArrayList<Edge>();
                bps.add(new Edge(0,0,0,1,3,0));
                bps.add(new Edge(1,3,0,1,5,0));
                bps.add(new Edge(1,5,0,0,8,0));
                BoundaryPart part = new BoundaryPart(bps);
                part.connectPoint(new Point(3,4,0));
                bps = part.getBoundaryEdges();
                assertTrue(bps.get(0).equals(new Edge(0,0,0,3,4,0)));
                assertTrue(bps.get(1).equals(new Edge(0,8,0,3,4,0)));
                assertTrue(bps.size()==2);
        }

}
