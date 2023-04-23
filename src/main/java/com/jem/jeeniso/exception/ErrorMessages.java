package com.jem.jeeniso.exception;

public interface ErrorMessages {


  String AUTHENTICATION_USER_NOT_VALID = "These credentials do not match our records !";


  String USER_ALREADY_EXISTS = "User already exist ";
  String REGISTER_PROCESS_NOT_VALID = "There is an account with that email address";


  String PROJECT_NOT_FOUND = "Project not found ";
  String PROJECT_ALREADY_EXISTS = "Project already exists ";
  String PROJECT_MANAGER_ALREADY_IN_USE = "Project manager already in use ";


  String USER_NOT_FOUND_BY_ID = "Couldn't find your ID !";
  String USER_NOT_FOUND_BY_EMAIL = "Couldn't find your email !";
  String USER_OUT_OF_SERVICE = "User temporarily out of service ";

  String ADMIN_NOT_FOUND = "Admin not found ";


  String ROLE_NOT_FOUND_BY_NAME = "Role not found ";
  String ROLE_NOT_FOUND_BY_ID = "Role not found with id: ";
  String ROLE_ALREADY_EXISTS = "Role already exists ";

  String CHANGE_PASSWORD_ERROR = "The old password you have entered is incorrect";

  String TASK_NOT_FOUND="the task was not found";

  String EVALUATIONGRID_ALREADY_EXISTS = "Evaluation Grid already exists ";


  String EVENT_ALREADY_EXISTS = "Event already exists ";
  String BUSY_EVENTDate = "There is already an event in this date";

  String JUNIORENTREPRISE_ALREADY_EXISTS= " Junior Entreprise Already exists";

  String MEDIA_ALREADY_EXISTS= " Junior Entreprise Already exists";
  String MEDIA_NOT_FOUND_BY_NAME= " media not found";
  String CALENDAR_NOT_FOUND_BY_NAME="calendar not found by name";
  String KPI_NOT_FOUND_BY_NAME="kpi not found by name";

  String BUSY_MEETINGDate = "There is already a meeting in this date";

  String TRAINER_ALREADY_EXISTS ="The trainer already exists";

  String TASK_ALREADY_EXISTS= "This task already exists";

  String PV_ALREADY_EXISTS= "there is already a PV with the same title";

  String PROSPECT_ALREADY_EXISTS ="This prospect already exists ";

  String PROSPECT_NOT_FOUND_BY_OrganizationName="This prospect does not exists ";

  String PARTNER_ALREADY_EXISTS="This partner already exists ";

  String PARTNER_NOT_FOUND_BY_OrganizationName="This partner does not exists ";

}