/**
 * 
 */
package com.project.webapp.devtools.converters;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Area {

	@RequestMapping(value="area/{id}/circle", method=RequestMethod.GET)
	public Double areaCircle(@PathVariable Double id){
		return Math.PI*id*id;
	}
	
	@RequestMapping(value="area/{id}/square", method=RequestMethod.GET)
	public Double areaSquare(@PathVariable Double id){
		return id*id;
	}
	
	@RequestMapping(value="area/{length}/rectangle/{width}", method=RequestMethod.GET)
	public Double areaRectangle(@PathVariable("length") Double length, @PathVariable("width") Double width){
		return length*width;
	}
	
	@RequestMapping(value="area/triangle/first/{first}/second/{second}/third/{third}", method=RequestMethod.GET)
	public Double areaTriangleThreeSides(@PathVariable Double first, @PathVariable Double second, @PathVariable Double third ){
		Double perimeter = first+second+third;
		Double semiPerimeter = perimeter/2;
		return Math.sqrt(semiPerimeter*(semiPerimeter-first)*(semiPerimeter-second)*(semiPerimeter-third));
	}
	
	@RequestMapping(value="area/triangle/base/{base}/height/{height}", method=RequestMethod.GET)
	public Double areaTriangle(@PathVariable Double base, @PathVariable Double height ){
		return (base* height)/2;
	}
}
