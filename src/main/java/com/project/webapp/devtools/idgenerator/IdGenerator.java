/**
 * 
 */
package com.project.webapp.devtools.idgenerator;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import com.project.webapp.devtools.model.UUIDModel;
/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class IdGenerator {
	
	NoArgGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
	
	// Generate One UUID Version 4 
	@RequestMapping(value = "generate/uuid4",method=RequestMethod.GET)
	public UUID generateOneuuid(){
		return UUID.randomUUID();
	}
	
	// Generate Multiple UUID Version 4
	@RequestMapping(value = "generate/uuid4/{id}", method=RequestMethod.GET)
	public UUIDModel generateMultipleuuid(@PathVariable Long id){
		String uuids = "";
		UUIDModel uuidModel = new UUIDModel();
		for(int i=0; i < id; i++){
			uuids = uuids + UUID.randomUUID() + "\n";			
		}
		uuidModel.setUuid(uuids);
		return uuidModel;
	}

	
	// Generate One UUID Version 4 without dashes 
	@RequestMapping(value = "generate/uuid4/dash",method=RequestMethod.GET)
	public UUIDModel generateOneuuidWithoutDashes(){
		
		UUIDModel uuidModel = new UUIDModel();
		uuidModel.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
		return uuidModel;
	}
	
	// Generate Multiple UUID Version 4 without dashes
	@RequestMapping(value = "generate/uuid4/dash/{id}", method=RequestMethod.GET)
	public UUIDModel generateMultipleuuidWithoutDashes(@PathVariable Long id){		
		String uuids = "";
		for(int i=0; i < id; i++){
			uuids = uuids + UUID.randomUUID().toString().replaceAll("-", "") + "\n";			
		}
		UUIDModel uuidModel = new UUIDModel();
		uuidModel.setUuid(uuids);
		return uuidModel;
	}

	// Generate One UUID Version 1
	@RequestMapping(value = "generate/uuid1",method=RequestMethod.GET)
	public UUID generateVersionOneuuid(){
		return timeBasedGenerator.generate();
	}
		
	// Generate Multiple UUID Version 1
	@RequestMapping(value = "generate/uuid1/{id}", method=RequestMethod.GET)
	public UUIDModel generateVersionOneMultipleuuid(@PathVariable Long id){
		String uuids = "" ; 
		for(int i=0; i < id; i++){
			uuids = uuids + timeBasedGenerator.generate() + "\n" ;			
		}
		UUIDModel model = new UUIDModel();
		model.setUuid(uuids);
		return model;
	}
		
	// Generate One UUID Version 4 without dashes 
	@RequestMapping(value = "generate/uuid1/dash",method=RequestMethod.GET)
	public UUIDModel generateVersionOneuuidWithoutDashes(){
		UUIDModel uuidModel = new UUIDModel();
		uuidModel.setUuid(timeBasedGenerator.generate().toString().replaceAll("-", ""));
		return uuidModel;
		
	}
	
	// Generate Multiple UUID Version 4 without dashes
	@RequestMapping(value = "generate/uuid1/dash/{id}", method=RequestMethod.GET)
	public UUIDModel generateVersionOneMultipleuuidWithoutDashes(@PathVariable Long id){
		String uuids = "";
		for(int i=0; i < id; i++){
			uuids = uuids + timeBasedGenerator.generate().toString().replaceAll("-", "") + "\n";		
		}
		UUIDModel model = new UUIDModel();
		model.setUuid(uuids);
		return model;
	}
		
}
