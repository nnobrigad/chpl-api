package gov.healthit.chpl.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gov.healthit.chpl.auth.Util;
import gov.healthit.chpl.auth.permission.GrantedPermission;
import gov.healthit.chpl.auth.user.UserRetrievalException;
import gov.healthit.chpl.domain.ActivityConcept;
import gov.healthit.chpl.domain.ActivityEvent;
import gov.healthit.chpl.domain.UserActivity;
import gov.healthit.chpl.dto.ApiKeyDTO;
import gov.healthit.chpl.manager.ActivityManager;
import gov.healthit.chpl.manager.ApiKeyManager;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;

@Api(value = "activity")
@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityManager activityManager;
	
	@Autowired
	private ApiKeyManager apiKeyManager;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activity(@RequestParam(required=false) Integer lastNDays,
			@RequestParam(value = "showDeleted", required=false, defaultValue="false") boolean showDeleted) throws JsonParseException, IOException{
		if(!Util.isUserRoleAdmin() && showDeleted){
			throw new AccessDeniedException("Only Admin can see deleted ACB's/ATL's");
		}else{
			if (lastNDays == null){
				return getActivityEvents(showDeleted);
			} else {
				return getActivityEvents(showDeleted, lastNDays);
			}
		}
	}
	
	@RequestMapping(value="/acbs", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForACBs(@RequestParam(required=false) Integer lastNDays,
			@RequestParam(value = "showDeleted", required=false, defaultValue="false") boolean showDeleted) throws JsonParseException, IOException{

		if(!Util.isUserRoleAdmin() && showDeleted){
			throw new AccessDeniedException("Only Admins can see deleted ACB's");
		}else{
			if (lastNDays == null){
				return getActivityEventsForACBs(showDeleted);
			} else {
				return getActivityEventsForACBs(showDeleted, lastNDays);
			}
		}
	}
	
	@RequestMapping(value="/acbs/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForACBById(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays,
			@RequestParam(value = "showDeleted", required=false, defaultValue="false") boolean showDeleted) throws JsonParseException, IOException{

		if(!Util.isUserRoleAdmin() && showDeleted){
			throw new AccessDeniedException("Only Admins can see deleted ACB's");
		}else{
			if (lastNDays == null){
				return getActivityEventsForACBs(showDeleted, id);
			} else {
				return getActivityEventsForACBs(showDeleted, id, lastNDays);
			}
		}
	}
	
	@RequestMapping(value="/atls", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityforATLs(@RequestParam(required=false) Integer lastNDays,
			@RequestParam(value = "showDeleted", required=false, defaultValue="false") boolean showDeleted) throws JsonParseException, IOException{

		if(!Util.isUserRoleAdmin() && showDeleted){
			throw new AccessDeniedException("Only Admins can see deleted ATL's");
		}else{
			if (lastNDays == null){
				return getActivityEventsForATLs(showDeleted);
			} else {
				return getActivityEventsForATLs(showDeleted, lastNDays);
			}
		}
	}

	@RequestMapping(value="/atls/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForATLById(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays,
			@RequestParam(value = "showDeleted", required=false, defaultValue="false") boolean showDeleted) throws JsonParseException, IOException{

		if(!Util.isUserRoleAdmin() && showDeleted){
			throw new AccessDeniedException("Only Admins can see deleted ATL's");
		}else{
			if (lastNDays == null){
				return getActivityEventsForATLs(showDeleted, id);
			} else {
				return getActivityEventsForATLs(showDeleted, id, lastNDays);
			}
		}
	}
	
	@RequestMapping(value="/api_keys", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForApiKeys(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException {
		
		if (lastNDays == null){
			return getActivityEventsForApiKeys();
		} else {
			return getActivityEventsForApiKeys(lastNDays);
		}
	}
	
	
	@RequestMapping(value="/certified_products", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForCertifiedProducts(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForCertifiedProducts();
		} else {
			return getActivityEventsForCertifiedProducts(lastNDays);
		}
	}
	
	@RequestMapping(value="/certified_products/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForCertifiedProductById(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForCertifiedProducts(id);
		} else {
			return getActivityEventsForCertifiedProducts(id, lastNDays);
		}
	}
	
	
	@RequestMapping(value="/certifications", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForCertifications(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForCertifications();
		} else {
			return getActivityEventsForCertifications(lastNDays);
		}
	}
	
	@RequestMapping(value="/certifications/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForCertificationById(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForCertifications(id);
		} else {
			return getActivityEventsForCertifications(id, lastNDays);
		}
	}
	
	
	@RequestMapping(value="/pending_certified_products", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForPendingCertifiedProducts(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForPendingCertifiedProducts();
		} else {
			return getActivityEventsForPendingCertifiedProducts(lastNDays);
		}
	}
	
	@RequestMapping(value="/pending_certified_products/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForPendingCertifiedProducts(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForPendingCertifiedProducts(id);
		} else {
			return getActivityEventsForPendingCertifiedProducts(id, lastNDays);
		}
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForProducts(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForProducts();
		} else {
			return getActivityEventsForProducts(lastNDays);
		}
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForProducts(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForProducts(id);
		} else {
			return getActivityEventsForProducts(id, lastNDays);
		}
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForUsers(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForUsers();
		} else {
			return getActivityEventsForUsers(lastNDays);
		}
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForUsers(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForUsers(id);
		} else {
			return getActivityEventsForUsers(id, lastNDays);
		}
	}
	
	
	@RequestMapping(value="/developers", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForDevelopers(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForDevelopers();
		} else {
			return getActivityEventsForDevelopers(lastNDays);
		}
	}
	
	
	@RequestMapping(value="/developers/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityForDevelopers(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return getActivityEventsForDevelopers(id);
		} else {
			return getActivityEventsForDevelopers(id, lastNDays);
		}
	}
	
	
	@RequestMapping(value="/user_activities", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<UserActivity> activityByUser(@RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException, UserRetrievalException{
		
		if (lastNDays == null){
			return activityManager.getActivityByUser();
		} else {
			return activityManager.getActivityByUserInLastNDays(lastNDays);
		}
	}
	

	@RequestMapping(value="/user_activities/{id}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public List<ActivityEvent> activityByUser(@PathVariable("id") Long id, @RequestParam(required=false) Integer lastNDays) throws JsonParseException, IOException{
		
		if (lastNDays == null){
			return activityManager.getActivityForUser(id);
		} else {
			return activityManager.getActivityForUserInLastNDays(id, lastNDays);
		}
	}
	
	
	private List<ActivityEvent> getActivityEventsForACBs(boolean showDeleted, Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION_BODY;
		events = getActivityEventsForObject(showDeleted, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForATLs(boolean showDeleted, Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_ATL;
		events = getActivityEventsForObject(showDeleted, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForCertifications(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForCertifiedProducts(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForPendingCertifiedProducts(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PENDING_CERTIFIED_PRODUCT;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForProducts(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PRODUCT;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForUsers(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_USER;
		
		Set<GrantedPermission> permissions = Util.getCurrentUser().getPermissions();
		
		// Only return data if the user has ROLE_ADMIN
		Boolean hasAdmin = false;
		for (GrantedPermission permission : permissions){
			if (permission.getAuthority().equals("ROLE_ADMIN")){
				hasAdmin = true;
			}
		}
		if (!hasAdmin){
			throw new AccessDeniedException("Insufficient permissions to access User activity.");
		} else {
			events = getActivityEventsForObject(false, concept, id);
		}
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForDevelopers(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_DEVELOPER;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForVersions(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_VERSION;
		events = getActivityEventsForObject(false, concept, id);
		return events;
		
	}
	
	private List<ActivityEvent> getActivityEventsForApiKeys(Long id) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_API_KEY;
		events = getActivityEventsForObject(false, concept, id);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForACBs(boolean showDeleted, Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION_BODY;
		events = getActivityEventsForObject(showDeleted, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForATLs(boolean showDeleted, Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_ATL;
		events = getActivityEventsForObject(showDeleted, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForCertifications(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	
	private List<ActivityEvent> getActivityEventsForCertifiedProducts(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForPendingCertifiedProducts(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PENDING_CERTIFIED_PRODUCT;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForProducts(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PRODUCT;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForUsers(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_USER;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForDevelopers(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_DEVELOPER;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForVersions(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_VERSION;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
		
	}
	
	private List<ActivityEvent> getActivityEventsForApiKeys(Long id, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_API_KEY;
		events = getActivityEventsForObject(false, concept, id, lastNDays);
		return events;
	}
	
	
	
	
	
	
	private List<ActivityEvent> getActivityEventsForACBs(boolean showDeleted, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION_BODY;
		events = getActivityEventsForConcept(showDeleted, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForATLs(boolean showDeleted, Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_ATL;
		events = getActivityEventsForConcept(showDeleted, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForCertifications(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	
	private List<ActivityEvent> getActivityEventsForCertifiedProducts(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForPendingCertifiedProducts(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PENDING_CERTIFIED_PRODUCT;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForProducts(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PRODUCT;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForUsers(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_USER;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForDevelopers(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_DEVELOPER;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForVersions(Integer lastNDays) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_VERSION;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		return events;
		
	}
	
	private List<ActivityEvent> getActivityEventsForApiKeys(Integer lastNDays) throws JsonParseException, IOException {
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_API_KEY;
		events = getActivityEventsForConcept(false, concept, lastNDays);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForACBs(boolean showDeleted) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION_BODY;
		events = getActivityEventsForConcept(showDeleted, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForATLs(boolean showDeleted) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_ATL;
		events = getActivityEventsForConcept(showDeleted, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForCertifications() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFICATION;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	
	private List<ActivityEvent> getActivityEventsForCertifiedProducts() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_CERTIFIED_PRODUCT;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForPendingCertifiedProducts() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PENDING_CERTIFIED_PRODUCT;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForProducts() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_PRODUCT;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForUsers() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_USER;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForDevelopers() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_DEVELOPER;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForVersions() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_VERSION;
		events = getActivityEventsForConcept(false, concept);
		return events;
		
	}
	
	private List<ActivityEvent> getActivityEventsForApiKeys() throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		ActivityConcept concept = ActivityConcept.ACTIVITY_CONCEPT_API_KEY;
		events = getActivityEventsForConcept(false, concept);
		
		return events;
	}
	
	
	
	private List<ActivityEvent> getActivityEventsForConcept(boolean showDeleted, ActivityConcept concept) throws JsonParseException, IOException{
		return activityManager.getActivityForConcept(showDeleted, concept);
	}
	
	private List<ActivityEvent> getActivityEventsForConcept(boolean showDeleted, ActivityConcept concept, Integer lastNDays) throws JsonParseException, IOException{
		return activityManager.getActivityForConcept(showDeleted, concept);
	}
	
	private List<ActivityEvent> getActivityEventsForObject(boolean showDeleted, ActivityConcept concept, Long objectId) throws JsonParseException, IOException{
		return activityManager.getActivityForObject(showDeleted, concept, objectId);
	}
	
	private List<ActivityEvent> getActivityEventsForObject(boolean showDeleted, ActivityConcept concept, Long objectId, Integer lastNDays) throws JsonParseException, IOException{
		return activityManager.getActivityForObject(showDeleted, concept, objectId, lastNDays);
	}
	
	private List<ActivityEvent> getActivityEvents(boolean showDeleted, Integer lastNDays) throws JsonParseException, IOException{
		return activityManager.getAllActivityInLastNDays(showDeleted, lastNDays);
	}
	
	private List<ActivityEvent> getActivityEvents(boolean showDeleted) throws JsonParseException, IOException{
		return activityManager.getAllActivity(showDeleted);
	}
	
	private List<ActivityEvent> getActivityEventsByUser(Integer lastNDays) throws JsonParseException, IOException{
		return activityManager.getAllActivityInLastNDays(false, lastNDays);
	}
	
	private List<ActivityEvent> getActivityByUserInLastNDays() throws JsonParseException, IOException{
		return activityManager.getAllActivity(false);
	}
	
	
	
	private List<ActivityEvent> getActivityEventsForConcept(boolean showDeleted, Long conceptId) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		
		for (ActivityConcept concept : ActivityConcept.values()) {
			if(concept.getId().equals(conceptId)){
				events =  getActivityEventsForConcept(showDeleted, concept);
				break;
			}
		}
		return events;
	}
	
	private List<ActivityEvent> getActivityEventsForConcept(boolean showDeleted, String conceptName) throws JsonParseException, IOException{
		
		List<ActivityEvent> events = null;
		
		for (ActivityConcept concept : ActivityConcept.values()) {
			if(concept.getName().equals(conceptName)){
				events =  getActivityEventsForConcept(showDeleted, concept);
				break;
			}
		}
		return events;
	}
	
}
