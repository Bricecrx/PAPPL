/* -----------------------------------------
  * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers;

import fr.centrale.nantes.neptune.controllers.tools.SecurityTools;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import fr.centrale.nantes.neptune.items.*;
import fr.centrale.nantes.neptune.repositories.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ECN
 */
@Controller
public class AjaxController {

    @Autowired
    private AcademicyearRepository academicyearRepository;

    @Autowired
    private DiplomRepository diplomRepository;

    @Autowired
    private ConnectRepository connectRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired 
    private StudentgroupRepository groupRepository;
    
    @Autowired
    private StudentregistrationRepository studentregistrationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "ajax.do", method = RequestMethod.POST)
    public ModelAndView handlePost(HttpServletRequest request) {
        ModelAndView returned = new ModelAndView("ajax");
        JSONObject theResponse;

        // Force request map evaluation
        Map<String, String[]> mapList = request.getParameterMap();

        Connect connection = SecurityTools.checkAccess(connectRepository, request);
        if (connection != null) {
            // Connection is ok
            theResponse = processAction(connection, returned, request);
        } else {
            theResponse = new JSONObject();
        }
        returned.addObject("theResponse", theResponse);

        return returned;
    }

    private JSONObject processAction(Connect connection, ModelAndView returned, HttpServletRequest request) {
        JSONObject theResponse = new JSONObject();

        String action = request.getParameter("action");
        boolean responseIsOk = false;
        switch (action) {
            case "addAnnee":
                responseIsOk = addAnnee(theResponse, request);
                break;
            case "removeAnnee":
                responseIsOk = removeAnnee(theResponse, request);
                break;
            case "addDiplome":
                responseIsOk = addDiplome(theResponse, request);
                break;
            case "removeDiplome":
                responseIsOk = removeDiplome(theResponse, request);
                break;
            case "addProgram":
                responseIsOk = addProgram(theResponse, request);
                break;
            case "removeProgram":
                responseIsOk = removeProgram(theResponse, request);
                break;
            case "addPerson":
                responseIsOk = addPerson(theResponse, request);
                break;
            case "addStudent":
                responseIsOk = addStudent(theResponse, request);
                break;
            case "addGroup":
                responseIsOk = addGroup(theResponse, request);
                break;
            case "removePerson":
                responseIsOk = removePerson(theResponse, request);
                break;
            case "removeStudentFromGroup":
                responseIsOk = removeStudentFromGroup(theResponse, request);
                break;
            case "addCourse":
                responseIsOk = addCourse(theResponse, request);
                break;
            case "removeCourse":
                responseIsOk = removeCourse(theResponse, request);
                break;

        }

        // Validate / not
        if (responseIsOk) {
            theResponse.put("ok", 1);
        } else {
            theResponse.put("ok", 0);
        }

        return theResponse;
    }

    private boolean addAnnee(JSONObject theResponse, HttpServletRequest request) {
        String anneeLib = request.getParameter("anneeLib");
        String anneeAnneeStr = request.getParameter("anneeAnnee");
        int anneeAnnee = Integer.parseInt(anneeAnneeStr);

        Academicyear annee = academicyearRepository.create(anneeLib, anneeAnnee);
        theResponse.put("id", annee.getAcademicyearId());
        
        return true;
    }
    
    
    private boolean removeAnnee(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("anneeId");
        int itemId = Integer.parseInt(itemIdStr);
        
        Academicyear item = academicyearRepository.getById(itemId);
        if (item != null) {
            academicyearRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }

    private boolean addDiplome(JSONObject theResponse, HttpServletRequest request) {
        String diplomLib = request.getParameter("diplomeLib");
        Diplom diplom = diplomRepository.create(diplomLib);
        theResponse.put("id", diplom.getDiplomId());
        
        return true;
    }
    
    
    private boolean removeDiplome(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("diplomeId");
        int itemId = Integer.parseInt(itemIdStr);
        
        Diplom item = diplomRepository.getById(itemId);
        if (item != null) {
            diplomRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }

    private boolean addProgram(JSONObject theResponse, HttpServletRequest request) {
        String anneeIdStr = request.getParameter("anneeId");
        int anneeId = Integer.parseInt(anneeIdStr);
        Academicyear academicyear = academicyearRepository.getById(anneeId);
        String diplomeIdStr = request.getParameter("diplomeId");
        int diplomeId = Integer.parseInt(diplomeIdStr);
        Diplom diplom = diplomRepository.getById(diplomeId);
        Program program = programRepository.create(diplom, academicyear);
        theResponse.put("id", program.getProgramId());
        theResponse.put("annee", program.getAcademicyearId().getAcademicyearTitle());
        theResponse.put("diplom", program.getDiplomId().getDiplomName());
        
        return true;
    }
    
    
    private boolean removeProgram(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("programId");
        int itemId = Integer.parseInt(itemIdStr);
        
        Program item = programRepository.getById(itemId);
        if (item != null) {
            programRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }
    
    private boolean addPerson(JSONObject theResponse, HttpServletRequest request) {
        String personFirstname = request.getParameter("personFirstname");
        String personLastname = request.getParameter("personLastname");
        String personEmail = request.getParameter("personEmail");

        Person person = personRepository.create(personFirstname, personLastname, personEmail);
        theResponse.put("id", person.getPersonId());
        
        return true;
    }
    
    private boolean addStudent(JSONObject theResponse, HttpServletRequest request) {
        String personFirstname = request.getParameter("personFirstname");
        String personLastname = request.getParameter("personLastname");
        String personEmail = request.getParameter("personEmail");

        Person person = personRepository.create(personFirstname, personLastname, personEmail);
        Student student = studentRepository.create(person);
        
        
        theResponse.put("id", person.getPersonId());
        theResponse.put("id2", student.getStudentId());
        
        return true;
    }
    
    private boolean addGroup(JSONObject theResponse, HttpServletRequest request) {
        String groupName = request.getParameter("groupName");

        Studentgroup group = groupRepository.create(groupName);
        
        
        theResponse.put("id", group.getStudentgroupId());
        
        return true;
    }
    
    
    private boolean removePerson(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("personId");
        int itemId = Integer.parseInt(itemIdStr);
        
        Person item = personRepository.getById(itemId);
        if (item != null) {
            personRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }
    
    private boolean removeStudentFromGroup(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("studentregistrationId");
        String itemIdStr2 = request.getParameter("groupId");
        int itemId = Integer.parseInt(itemIdStr);
        int itemId2 = Integer.parseInt(itemIdStr2);
        
        Studentgroup group = groupRepository.getById(itemId2);
        Studentregistration item = studentregistrationRepository.getById(itemId);
        if (item != null) {
            group.getStudentregistrationCollection().remove(item);
            studentregistrationRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }

    private boolean addCourse(JSONObject theResponse, HttpServletRequest request) {
        String courseTitle = request.getParameter("courseTitle");
        String courseAbrev = request.getParameter("courseAbrev");
        String programIdStr = request.getParameter("programId");
        int programId = Integer.parseInt(programIdStr);

        Program program = programRepository.getByProgramId(programId);
        Course course = courseRepository.create(courseTitle, courseAbrev, program);
        theResponse.put("id", course.getCourseId());
        
        return true;
    }
    
    
    private boolean removeCourse(JSONObject theResponse, HttpServletRequest request) {
        String itemIdStr = request.getParameter("courseId");
        int itemId = Integer.parseInt(itemIdStr);
        
        Course item = courseRepository.getById(itemId);
        if (item != null) {
            courseRepository.remove(item);
            theResponse.put("id", itemId);
            return true;
        } else {
            return false;
        }
    }
}
