package com.bluespacetech.security.constants;

import com.bluespacetech.core.constants.Labeled;

/**
 * Enums for Authority constants
 *
 * @author Pradeep
 */
public enum GrantConstant implements Labeled {

	NONE("none","NONE"),

	ACCESS_BRANCHS("access_branchs","UI_BRANCHES_ACCESS"),
	CREATE_BRANCH("create_branch","UI_BRANCH_CREATE"),
	UPDATE_BRANCH("update_branch","UI_BRANCH_UPDATE"),
	DELETE_BRANCH("delete_branch","UI_BRANCH_DELETE"),

	ACCESS_DASHBOARD("access_dashboard","UI_DASHBOARD_ACCESS"),
	ACCESS_DASHBOARD_FEES_COLLECTED("access_dashboard","UI_DASHBOARD_FEES_COLLECTED_ACCESS"),
	ACCESS_DASHBOARD_STUDENT_ATTENDANCE("access_dashboard","UI_DASHBOARD_STUDENT_ATTENDANCE_ACCESS"),
	ACCESS_DASHBOARD_EMPLOYEE_ATTENDANCE("access_dashboard","UI_DASHBOARD_EMPLOYEE_ATTENDANCE_ACCESS"),
	ACCESS_DASHBOARD_EXPENSES("access_dashboard","UI_DASHBOARD_EXPENSES_ACCESS"),
	ACCESS_DASHBOARD_EXPENSES_GRAPH("access_dashboard","UI_DASHBOARD_EXPENSES_GRAPH_ACCESS"),
	ACCESS_DASHBOARD_FEES_COLLECTED_GRAPH("access_dashboard","UI_DASHBOARD_FEES_COLLECTED_GRAPH_ACCESS"),

	ACCESS_SETUP("access_setup","UI_SETUP_ACCESS"),

	ACCESS_NOTIFICATIONS("access_notifications","UI_"),
	ACCESS_STUDENT_NOTIFICATIONS("access_student_notifications","UI_"),
	ACCESS_EMPLOYEE_NOTIFICATIONS("access_employee_notifications","UI_"),
	ACCESS_ADHOC_NOTIFICATIONS("access_adhoc_notifications","UI_"),
	ACCESS_ADMISSION_NOTIFICATIONS("access_admission_notifications","UI_"),

	SEND_STUDENT_NOTIFICATIONS("send_student_notifications","UI_"),
	SEND_EMPLOYEE_NOTIFICATIONS("send_employee_notifications","UI_"),
	SEND_ADHOC_NOTIFICATIONS("send_adhoc_notifications","UI_"),
	SEND_ADMISSION_NOTIFICATIONS("send_admission_notifications","UI_"),

	ACCESS_USER_MANAGEMENT("access_user_management","UI_USER_MANAGEMENT_ACCESS"),
	ACCESS_ROLES("access_roles","UI_ROLES_ACCESS"),
	CREATE_ROLES("create_roles","UI_ROLES_CREATE"),
	UPDATE_ROLES("update_roles","UI_ROLES_UPDATE"),
	DELETE_ROLES("delete_roles","UI_ROLES_DELETE"),

	ACCESS_GROUPS("access_groups","UI_GROUPS_ACCESS"),
	CREATE_GROUPS("create_groups","UI_GROUPS_CREATE"),
	UPDATE_GROUPS("update_groups","UI_GROUPS_UPDATE"),
	DELETE_GROUPS("delete_groups","UI_GROUPS_DELETE"),

	ACCESS_USERS("access_users","UI_USERS_ACCESS"),
	CREATE_USERS("create_users","UI_USERS_CREATE"),
	UPDATE_USERS("update_users","UI_USERS_UPDATE"),
	DELETE_USERS("delete_users","UI_USERS_DELETE"),

	ACCESS_ORGANIZATION("access_organization","UI_ORGANIZATION_ACCESS"),
	CREATE_ORGANIZATION("create_organization","UI_ORGANIZATION_CREATE"),
	UPDATE_ORGANIZATION("update_organization","UI_ORGANIZATION_UPDATE"),
	DELETE_ORGANIZATION("delete_organization","UI_ORGANIZATION_DELETE"),

	ACCESS_ORGANIZATION_RECEIPT_IMAGE("access_organization","UI_ORGANIZATION_RECEIPT_IMAGE_ACCESS"),
	CREATE_ORGANIZATION_RECEIPT_IMAGE("create_organization","UI_ORGANIZATION_RECEIPT_IMAGE_CREATE"),
	UPDATE_ORGANIZATION_RECEIPT_IMAGE("update_organization","UI_ORGANIZATION_RECEIPT_IMAGE_UPDATE"),
	DELETE_ORGANIZATION_RECEIPT_IMAGE("delete_organization","UI_ORGANIZATION_RECEIPT_IMAGE_DELETE"),

	ACCESS_ORGANIZATION_LOGO_IMAGE("access_organization","UI_ORGANIZATION_LOGO_IMAGE_ACCESS"),
	CREATE_ORGANIZATION_LOGO_IMAGE("create_organization","UI_ORGANIZATION_LOGO_IMAGE_CREATE"),
	UPDATE_ORGANIZATION_LOGO_IMAGE("update_organization","UI_ORGANIZATION_LOGO_IMAGE_UPDATE"),
	DELETE_ORGANIZATION_LOGO_IMAGE("delete_organization","UI_ORGANIZATION_LOGO_IMAGE_DELETE"),

	ACCESS_FINANCIAL_YEAR("access_financial_year","UI_FINANCIAL_YEAR_ACCESS"),
	CREATE_FINANCIAL_YEAR("create_financial_year","UI_FINANCIAL_YEAR_CREATE"),
	UPDATE_FINANCIAL_YEAR("update_financial_year","UI_FINANCIAL_YEAR_UPDATE"),
	DELETE_FINANCIAL_YEAR("delete_financial_year","UI_FINANCIAL_YEAR_DELETE"),

	ACCESS_FEE_CATEGORY("access_fee_category","UI_FEE_CATEGORY_ACCESS"),
	CREATE_FEE_CATEGORY("create_fee_category","UI_FEE_CATEGORY_CREATE"),
	UPDATE_FEE_CATEGORY("update_fee_category","UI_FEE_CATEGORY_UPDATE"),
	DELETE_FEE_CATEGORY("delete_fee_category","UI_FEE_CATEGORY_DELETE"),

	ACCESS_ADD_FEES("access_add_fees","UI_ADD_FEES_ACCESS"),
	CREATE_ADD_FEES("create_add_fees","UI_ADD_FEES_CREATE"),
	UPDATE_ADD_FEES("update_add_fees","UI_ADD_FEES_UPDATE"),
	DELETE_ADD_FEES("delete_add_fees","UI_ADD_FEES_DELETE"),

	ACCESS_FEE_STRUCTURE("access_fee_structure","UI_"),
	ACCESS_FEE_DETAILS("access_fee_details","UI_"),

	ACCESS_COLLECT_FEES("access_collect_fees","UI_"),

	ACCESS_FEE_MANAGEMENT("access_fee_management","UI_"),

	ACCESS_ADMINISTRATION("access_administration","UI_"),

	ACCESS_HRM("access_hrm","UI_HRM_ACCESS"),

	ACCESS_ACADEMIC_YEAR("access_academic_year","UI_ACADEMIC_YEAR_ACCESS"),
	CREATE_ACADEMIC_YEAR("create_academic_year","UI_ACADEMIC_YEAR_CREATE"),
	UPDATE_ACADEMIC_YEAR("update_academic_year","UI_ACADEMIC_YEAR_UPDATE"),
	DELETE_ACADEMIC_YEAR("delete_academic_year","UI_ACADEMIC_YEAR_DELETE"),

	ACCESS_ACADEMIC_BATCH("access_academic_batch","UI_ACADEMIC_BATCH_ACCESS"),
	CREATE_ACADEMIC_BATCH("create_academic_batch","UI_ACADEMIC_BATCH_CREATE"),
	UPDATE_ACADEMIC_BATCH("update_academic_batch","UI_ACADEMIC_BATCH_UPDATE"),
	DELETE_ACADEMIC_BATCH("delete_academic_batch","UI_ACADEMIC_BATCH_DELETE"),

	ACCESS_SECTION("access_section","UI_SECTION_ACCESS"),
	CREATE_SECTION("create_section","UI_SECTION_CREATE"),
	UPDATE_SECTION("update_section","UI_SECTION_UPDATE"),
	DELETE_SECTION("delete_section","UI_SECTION_DELETE"),

	ACCESS_SUBJECT("access_subject","UI_SUBJECT_ACCESS"),
	CREATE_SUBJECT("create_subject","UI_SUBJECT_CREATE"),
	UPDATE_SUBJECT("update_subject","UI_SUBJECT_UPDATE"),
	DELETE_SUBJECT("delete_subject","UI_SUBJECT_DELETE"),

	ACCESS_IMPORT_EXISTING_ADMISSIONS("access_import_existing_admissions","UI_"),
	ACCESS_IMPORT_ADMISSIONS("access_import_admissions","UI_"),

	ACCESS_BRANCH_RULE("access_branch_rule","UI_"),
	ACCESS_BRANCH_SETTINGS("access_branch_settings","UI_"),
	UPDATE_BRANCH_RULE("update_branch_rule","UI_"),

	ACCESS_BRANCH_STUDENT_NOTIFICATION_SETTINGS("access_branch_student_notification_settings","UI_"),
	UPDATE_BRANCH_STUDENT_NOTIFICATION_SETTINGS("access_branch_student_notification_settings","UI_"),
	ACCESS_BRANCH_EMPLOYEE_NOTIFICATION_SETTINGS("access_branch_employee_notification_settings","UI_"),
	UPDATE_BRANCH_EMPLOYEE_NOTIFICATION_SETTINGS("access_branch_employee_notification_settings","UI_"),

	ACCESS_SMS_PROVIDER("access_sms_provider","UI_SMS_PROVIDER_ACCESS"),
	CREATE_SMS_PROVIDER("create_sms_provider","UI_SMS_PROVIDER_CREATE"),
	UPDATE_SMS_PROVIDER("update_sms_provider","UI_SMS_PROVIDER_UPDATE"),
	DELETE_SMS_PROVIDER("delete_sms_provider","UI_SMS_PROVIDER_DELETE"),

	ACCESS_TRANSFER_STUDENTS("access_transfer_students","UI_TRANSFER_STUDENTS_ACCESS"),
	CREATE_TRANSFER_STUDENTS("create_transfer_students","UI_TRANSFER_STUDENTS_UPDATE"),

	ACCESS_CLASS("access_class","UI_CLASS_ACCESS"),
	CREATE_CLASS("create_class","UI_CLASS_CREATE"),
	UPDATE_CLASS("update_class","UI_CLASS_UPDATE"),
	DELETE_CLASS("delete_class","UI_CLASS_DELETE"),

	ACCESS_ACCOUNT_SETTINGS("access_account_settings","UI_"),
	ACCESS_SWITCH_BRANCH("access_switch_branch","UI_"),
	UPDATE_SWITCH_BRANCH("update_switch_branch","UI_"),
	ACCESS_PREFERRED_BRANCH("access_preferred_branch","UI_"),
	UPDATE_PREFERRED_BRANCH("update_preferred_branch","UI_"),
	ACCESS_CHANGE_PASSWORD("access_change_password","UI_"),
	UPDATE_CHANGE_PASSWORD("update_change_password","UI_"),

	ACCESS_STUDENTS_TOGGLE("access_students_toggle","UI_STUDENTS_TOGGLE_ACCESS"),
	ACCESS_STUDENTS("access_students","UI_STUDENTS_ACCESS"),
	ACCESS_UPLOAD_STUDENT_PICTURES("ACCESS_UPLOAD_STUDENT_PICTURES","UI_UPLOAD_STUDENT_PICTURES_ACCESS"),
	VIEW_STUDENT_PERSONAL_INFO("view_student_personal_info","UI_STUDENT_PERSONAL_INFO_VIEW"),
	UPDATE_STUDENT_PERSONAL_INFO("update_student_personal_info","UI_STUDENT_PERSONAL_INFO_UPDATE"),
	VIEW_STUDENT_CONTACT_INFO("view_student_contact_info","UI_STUDENT_CONTACT_INFO_VIEW"),
	UPDATE_STUDENT_CONTACT_INFO("update_student_contact_info","UI_STUDENT_CONTACT_INFO_UPDATE"),
	VIEW_STUDENT_ADDRESS("view_student_address","UI_STUDENT_ADDRESS_VIEW"),
	UPDATE_STUDENT_ADDRESS("update_student_address","UI_STUDENT_ADDRESS_UPDATE"),
	VIEW_STUDENT_PICTURE("view_student_picture","UI_STUDENT_PICTURE_VIEW"),
	UPDATE_STUDENT_PICTURE("update_student_picture","UI_STUDENT_PICTURE_UPDATE"),

	ACCESS_ADMISSIONS("access_admissions","UI_"),
	SUBMIT_ADMISSIONS("submit_admissions","UI_"),
	UPDATE_ADMISSIONS("update_admissions","UI_"),
	REVIEW_ADMISSIONS("review_admissions","UI_"),
	ACCEPT_ADMISSIONS("accept_admissions","UI_"),
	ADMIT_ADMISSIONS("admit_admissions","UI_"),
	REJECT_ADMISSIONS("reject_admissions","UI_"),

	ACCESS_STUDENT_FEE("access_student_fee","UI_STUDENT_FEE_ACCESS"),
	CREATE_STUDENT_FEE("create_student_fee","UI_STUDENT_FEE_CREATE"),
	DELETE_STUDENT_FEE("delete_student_fee","UI_STUDENT_FEE_DELETE"),

	ACCESS_STUDENT_ADDITIONAL_FEE("access_student_fee","UI_STUDENT_ADDITIONAL_FEE_ACCESS"),
	CREATE_STUDENT_ADDITIONAL_FEE("create_student_fee","UI_STUDENT_ADDITIONAL_FEE_CREATE"),
	UPDATE_STUDENT_ADDITIONAL_FEE("create_student_fee","UI_STUDENT_ADDITIONAL_FEE_UPDATE"),
	DELETE_STUDENT_ADDITIONAL_FEE("delete_student_fee","UI_STUDENT_ADDITIONAL_FEE_DELETE"),

	ACCESS_STUDENT_FEE_PAYMENT("access_student_fee_payment","UI_STUDENT_FEE_PAYMENT_ACCESS"),
	ACCESS_STUDENT_FEE_WAIVE("access_student_fee_waive","UI_STUDENT_FEE_WAIVE_ACCESS"),
	ACCESS_STUDENT_FEE_REFUND("access_student_fee_refund","UI_STUDENT_FEE_REFUND_ACCESS"),
	PROCESS_STUDENT_FEE_PAYMENT("process_student_fee_payment","UI_STUDENT_FEE_PAYMENT_PROCESS"),
	PROCESS_STUDENT_FEE_WAIVE("process_student_fee_waive","UI_STUDENT_FEE_WAIVE_PROCESS"),
	PROCESS_STUDENT_FEE_REFUND("process_student_fee_refund","UI_STUDENT_FEE_REFUND_PROCESS"),
	REJECT_STUDENT_FEE("reject_student_fee","UI_STUDENT_FEE_REJECT"),
	REJECT_STUDENT_FEE_REFUND("reject_student_fee_refund","UI_STUDENT_FEE_REFUND_REJECT"),
	REJECT_STUDENT_FEE_WAIVE("reject_student_fee_waive","UI_STUDENT_FEE_WAIVE_REJECT"),
	REJECT_STUDENT_FEE_PAYMENT("reject_student_fee_payment","UI_STUDENT_FEE_PAYMENT_REJECT"),

	REQUEST_STUDENT_FEE_WAIVE("request_student_fee_waive","UI_STUDENT_FEE_WAIVE_REQUEST"),
	REQUEST_STUDENT_FEE_REFUND("request_student_fee_refund","UI_STUDENT_FEE_REFUND_REQUEST"),

	ACCESS_STUDENT_ATTENDANCE("access_student_attendance","UI_STUDENT_ATTENDANCE_ACCESS"),
	CREATE_STUDENT_ATTENDANCE("create_student_attendance","UI_STUDENT_ATTENDANCE_CREATE"),
	UPDATE_STUDENT_ATTENDANCE("create_student_attendance","UI_STUDENT_ATTENDANCE_UPDATE"),
	DELETE_STUDENT_ATTENDANCE("delete_student_attendance","UI_STUDENT_ATTENDANCE_DELETE"),

	ACCESS_ADMISSION_CLASSIFICATION("access_admission_classification","UI_ADMISSION_CLASSIFICATION_ACCESS"),
	CREATE_ADMISSION_CLASSIFICATION("create_admission_classification","UI_ADMISSION_CLASSIFICATION_CREATE"),
	UPDATE_ADMISSION_CLASSIFICATION("update_admission_classification","UI_ADMISSION_CLASSIFICATION_UPDATE"),
	DELETE_ADMISSION_CLASSIFICATION("delete_admission_classification","UI_ADMISSION_CLASSIFICATION_DELETE"),

	ACCESS_ADMISSION_DOCUMENTS("access_admission_documents","UI_ADMISSION_DOCUMENTS_ACCESS"),
	CREATE_ADMISSION_DOCUMENTS("create_admission_documents","UI_ADMISSION_DOCUMENTS_CREATE"),
	UPDATE_ADMISSION_DOCUMENTS("update_admission_documents","UI_ADMISSION_DOCUMENTS_UPDATE"),
	DELETE_ADMISSION_DOCUMENTS("delete_admission_documents","UI_ADMISSION_DOCUMENTS_DELETE"),

	ACCESS_EMPLOYEE("access_employee","UI_EMPLOYEE_ACCESS"),
	CREATE_EMPLOYEE("create_employee","UI_EMPLOYEE_CREATE"),
	UPDATE_EMPLOYEE("update_employee","UI_EMPLOYEE_UPDATE"),
	DELETE_EMPLOYEE("delete_employee","UI_EMPLOYEE_DELETE"),

	ACCESS_DEPARTMENT("access_department","UI_DEPARTMENT_ACCESS"),
	CREATE_DEPARTMENT("create_department","UI_DEPARTMENT_CREATE"),
	UPDATE_DEPARTMENT("update_department","UI_DEPARTMENT_UPDATE"),
	DELETE_DEPARTMENT("delete_department","UI_DEPARTMENT_DELETE"),

	ACCESS_DESIGNATION("access_designation","UI_DESIGNATION_ACCESS"),
	CREATE_DESIGNATION("create_designation","UI_DESIGNATION_CREATE"),
	UPDATE_DESIGNATION("update_designation","UI_DESIGNATION_UPDATE"),
	DELETE_DESIGNATION("delete_designation","UI_DESIGNATION_DELETE"),

	ACCESS_ENQUIRIES("access_enquiries","UI_"),
	ACCESS_REGISTRATIONS("access_registrations","UI_"),

	ACCESS_ACADEMICS("access_academics","UI_ACADEMICS_ACCESS"),

	ACCESS_EXAMS("access_exam_types","UI_EXAMS_ACCESS"),
	CREATE_EXAMS("create_exam_types","UI_EXAMS_CREATE"),
	UPDATE_EXAMS("update_exam_types","UI_EXAMS_UPDATE"),
	DELETE_EXAMS("delete_exam_types","UI_EXAMS_DELETE"),

	ACCESS_SCHEDULE_EXAMS("access_schedule_exams","UI_SCHEDULE_EXAMS_ACCESS"),
	CREATE_SCHEDULE_EXAMS("create_schedule_exams","UI_SCHEDULE_EXAMS_CREATE"),
	UPDATE_SCHEDULE_EXAMS("update_schedule_exams","UI_SCHEDULE_EXAMS_UPDATE"),
	DELETE_SCHEDULE_EXAMS("delete_schedule_exams","UI_SCHEDULE_EXAMS_DELETE"),

	ACCESS_STUDENT_EXAMS("access_exam_types","UI_STUDENT_EXAMS_ACCESS"),
	CREATE_STUDENT_EXAMS("create_exam_types","UI_STUDENT_EXAMS_CREATE"),
	UPDATE_STUDENT_EXAMS("update_exam_types","UI_STUDENT_EXAMS_UPDATE"),
	DELETE_STUDENT_EXAMS("delete_exam_types","UI_STUDENT_EXAMS_DELETE"),

	ACCESS_EXAM_TYPES("access_exam_types","UI_EXAM_TYPES_ACCESS"),
	CREATE_EXAM_TYPES("create_exam_types","UI_EXAM_TYPES_CREATE"),
	UPDATE_EXAM_TYPES("update_exam_types","UI_EXAM_TYPES_UPDATE"),
	DELETE_EXAM_TYPES("delete_exam_types","UI_EXAM_TYPES_DELETE");

	// User Authorities
	private String label;
	private String grantUI;

	GrantConstant(final String label,final String grantUI) {
		this.label = label;
		this.grantUI = grantUI;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(final String label) {
		this.label = label;

	}

	/**
	 * @return the grantUI
	 */
	public String getGrantUI() {
		return grantUI;
	}

	/**
	 * @param grantUI the grantUI to set
	 */
	public void setGrantUI(final String grantUI) {
		this.grantUI = grantUI;
	}

}
