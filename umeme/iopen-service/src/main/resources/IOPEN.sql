----------------CUSTOMER CREDENTIALS--------------------------------------------------
--DROP TABLE ICSPROD.CLIENTE_PROFILE;

CREATE TABLE ICSPROD.CLIENTE_PROFILE(
    USUARIO  VARCHAR2(30) NOT NULL,
    F_ACTUAL DATE NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    COD_CLI NUMBER(9) NOT NULL,
    USERNAME VARCHAR2(100) NOT NULL ,
    USER_PASS VARCHAR2(250) NOT NULL,
    FULL_NAME VARCHAR2(100), 
    PHONE_NUMBER VARCHAR2(30),
    ACTIVE CHAR(1),
    ACTIVATION_TOKEN VARCHAR2(100),
    PRIMARY KEY (USERNAME)--,
    --FOREIGN KEY (COD_CLI) REFERENCES CLIENTES(COD_CLI)
);

CREATE PUBLIC SYNONYM CLIENTE_PROFILE FOR ICSPROD.CLIENTE_PROFILE;

GRANT ALL ON  ICSPROD.CLIENTE_PROFILE TO  ICSPROD;

--ALTER TABLE ICSPROD.CLIENTE_PROFILE ADD (FULL_NAME VARCHAR2(100), PHONE_NUMBER VARCHAR2(30));

--alter table ICSPROD.CLIENTE_PROFILE drop  constraint SYS_C00480415;

--ALTER TABLE ICSPROD.CLIENTE_PROFILE DROP PRIMARY KEY;

--ALTER TABLE  ICSPROD.CLIENTE_PROFILE ADD PRIMARY KEY(USERNAME);

--ALTER TABLE ICSPROD.CLIENTE_PROFILE MODIFY USER_PASS VARCHAR2(250);

--ALTER TABLE ICSPROD.CLIENTE_PROFILE  ADD ( ACTIVE CHAR(1), ACTIVATION_TOKEN VARCHAR2(100));


-------------------------GEOGRAPHICAL DISTRICTS MAPPING ---------------------------

CREATE TABLE ICSPROD.DISTRICT_DEPTOS (
    USUARIO  VARCHAR2(30) NOT NULL,
    F_ACTUAL DATE NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    COD_DISTRICT NUMBER(4) NOT NULL,
    NOM_DISTRICT VARCHAR2(50) NOT NULL,
    COD_DEPTO NUMBER(3) NOT NULL  ,
    COD_UNICOM NUMBER(5) ,
    PRIMARY KEY (COD_DISTRICT)      
);

--ALTER TABLE ICSPROD.DISTRICT_DEPTOS ADD FOREIGN KEY (COD_DEPTO) REFERENCES ICSPROD. DEPTOS (COD_DEPTO);
--ALTER TABLE  ICSPROD.DISTRICT_DEPTOS ADD  COD_UNICOM NUMBER(5);

CREATE PUBLIC SYNONYM DISTRICT_DEPTOS FOR ICSPROD.DISTRICT_DEPTOS;

GRANT ALL ON ICSPROD.DISTRICT_DEPTOS TO  ICSPROD;

----------------CUSTOMER CREDENTIALS--------------------------------------------------

CREATE TABLE ICSPROD.EMPLOYEE_PROFILE(
    USUARIO  VARCHAR2(30) NOT NULL,
    F_ACTUAL DATE NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    USERNAME VARCHAR2(100) NOT NULL,
    USER_PASS VARCHAR2(250) NOT NULL,
    PRIMARY KEY (USERNAME)
);

CREATE PUBLIC SYNONYM EMPLOYEE_PROFILE FOR ICSPROD.EMPLOYEE_PROFILE;

GRANT ALL ON  ICSPROD.EMPLOYEE_PROFILE TO  ICSPROD;

--ALTER TABLE ICSPROD.EMPLOYEE_PROFILE MODIFY USER_PASS VARCHAR2(250);

-------------------------APPLICATIONS TABLE ----------------------------------------------
--DROP TABLE ICSPROD.IOPEN_APPLICATIONS;

CREATE TABLE ICSPROD.IOPEN_APPLICATIONS(
    F_ACTUAL DATE  NOT NULL,
    USUARIO VARCHAR2(30)  NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    --COD_APPLICATION NUMBER(9)  NOT NULL,
    COD_APPLICATION VARCHAR2(9)  NOT NULL,
    
    APPLICATION_TYPE VARCHAR2(10),
    SURNAME VARCHAR2(50),
    FIRST_NAME VARCHAR2(50),
    MIDDLE_NAME VARCHAR2(50),
    ID_TYPE VARCHAR2(30),
    ID_NUMBER VARCHAR2(30),
    TIN_NUMBER VARCHAR2(30),
    MOBILE_NUMBER VARCHAR2(30),
    OFFICE_NUMBER VARCHAR2(30),
    EMAIL_ADDRESS VARCHAR2(100),
    CUSTOMER_CONTACT_PERSON VARCHAR2(30),
    CONTACT_NAME VARCHAR2(100),
    CONTACT_NUMBER VARCHAR2(30),
    
    DISTRICT VARCHAR2(30),
    VILLAGE VARCHAR2(30),
    LOCALITY VARCHAR2(30),
    STREET VARCHAR2(30),
    HOUSE_PLOT VARCHAR2(30),
    LANDMARK VARCHAR2(200),
    
    
    TERMS_AGREE VARCHAR2(4),
    EST_STATUS VARCHAR2(10),
    COMMENTS VARCHAR2(200),
    COMPLETE CHAR(1),
    AGREE_WAYLEAVES VARCHAR2(4),
    CO_REJECT_REASON VARCHAR2(5),
     
    INSPECTION_FEE NUMBER(9,2),    
    NUM_EXP VARCHAR2(30),    
    CLIENT_USERNAME VARCHAR2(100),
    
    INSPECTION_SCHEDULED CHAR(1) DEFAULT '0',
    INSPECTION_SCHEDULED_DATE DATE,
    INSPECTION_SCHEDULED_BY VARCHAR2(100),
    
    INSPECTION_REJECTED  CHAR(1) DEFAULT '0',
    INSPECTION_REJECT_CODE VARCHAR2(5),
    INSPECTION_REJECT_COMMENT  VARCHAR2(200),
    INSPECTION_REJECT_DATE DATE,
    INSPECTION_REJECT_BY VARCHAR2(100),
    
    
    CONNECTION_SCHEDULED CHAR(1) DEFAULT '0',
    CONNECTION_SCHEDULED_DATE DATE,
    CONNECTION_SCHEDULED_BY VARCHAR2(100),

   -- COD_CLI NUMBER(9),
    PRIMARY KEY (COD_APPLICATION),
    FOREIGN KEY (NUM_EXP) REFERENCES ICSPROD.EXPEDIENTES(NUM_EXP),
    --FOREIGN KEY (CLIENT_USERNAME,COD_CLI) REFERENCES  ICSPROD.CLIENTE_PROFILE(USERNAME,COD_CLI)
    FOREIGN KEY (CLIENT_USERNAME) REFERENCES  ICSPROD.CLIENTE_PROFILE(USERNAME)
);

--ALTER TABLE  ICSPROD.IOPEN_APPLICATIONS ADD INSPECTION_FEE NUMBER(9,2);
--ALTER TABLE  ICSPROD.IOPEN_APPLICATIONS ADD APPLICATION_TYPE VARCHAR2(10);
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD COMPLETE CHAR(1);

ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD AGREE_WAYLEAVES VARCHAR2(4);

ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD(
    INSPECTION_SCHEDULED CHAR(1) DEFAULT '0',
    INSPECTION_SCHEDULED_DATE DATE,
    INSPECTION_SCHEDULED_BY VARCHAR2(100)
);
    
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD(
    CONNECTION_SCHEDULED CHAR(1) DEFAULT '0',
    CONNECTION_SCHEDULED_DATE DATE,
    CONNECTION_SCHEDULED_BY VARCHAR2(100)
);
    
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS MODIFY (
    INSPECTION_SCHEDULED CHAR(1) DEFAULT '0',
    CONNECTION_SCHEDULED CHAR(1) DEFAULT '0'
);
    
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD ( LOCALITY VARCHAR2(30) , LANDMARK VARCHAR2(200));
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS modify ( LOCALITY not null , LANDMARK not null);


ALTER TABLE ICSPROD.IOPEN_APPLICATIONS modify (  DISTRICT number(9),
    VILLAGE  number(9),
    LOCALITY  number(9),
    STREET  number(9));

update ICSPROD.IOPEN_APPLICATIONS set LOCALITY = 0 where LOCALITY is null;

update ICSPROD.IOPEN_APPLICATIONS set village = 0 where village is null;

update ICSPROD.IOPEN_APPLICATIONS set district = 0 where district is null or district = ' ' ;

update ICSPROD.IOPEN_APPLICATIONS set LANDMARK =' ' where LANDMARK is null;


ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD CO_REJECT_REASON VARCHAR2(5);

ALTER TABLE ICSPROD.IOPEN_APPLICATIONS MODIFY INSPECTION_SCHEDULED CHAR(1) DEFAULT 'N';

ALTER TABLE ICSPROD.IOPEN_APPLICATIONS  ADD (    INSPECTION_REJECTED  CHAR(1) DEFAULT '0',
    INSPECTION_REJECT_CODE VARCHAR2(5),
    INSPECTION_REJECT_COMMENT  VARCHAR2(200),
    INSPECTION_REJECT_DATE DATE,
    INSPECTION_REJECT_BY VARCHAR2(100));

--ALTER TABLE ICSPROD.IOPEN_APPLICATIONS drop column COMPLETE;

CREATE PUBLIC SYNONYM IOPEN_APPLICATIONS FOR ICSPROD.IOPEN_APPLICATIONS;

GRANT ALL ON  ICSPROD.IOPEN_APPLICATIONS TO  ICSPROD;

CREATE SEQUENCE ICSPROD.COD_APPLICATION
  START WITH 1000000
  MAXVALUE 999999999
  MINVALUE 1000000
  CYCLE
  CACHE 20
  NOORDER;

CREATE PUBLIC SYNONYM COD_APPLICATION FOR ICSPROD.COD_APPLICATION;

GRANT ALL ON  ICSPROD.COD_APPLICATION TO  ICSPROD;

--------------------------DOCUMENTS UPLOADED --------------------------------------------
--DROP TABLE ICSPROD.IOPEN_APPLICATION_DOCS;

CREATE TABLE ICSPROD.IOPEN_APPLICATION_DOCS (
    F_ACTUAL DATE  NOT NULL,
    USUARIO VARCHAR2(30)  NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    COD_APPLICATION NUMBER(9)  NOT NULL,
    TIP_DOC VARCHAR2(100),
    DOC_DESC VARCHAR2(100),
    DOC BLOB,
    CONTENT_TYPE VARCHAR2(100),
    CONTENT_CLASS VARCHAR2(30),
    PRIMARY KEY (COD_APPLICATION, TIP_DOC),
    FOREIGN KEY (COD_APPLICATION) REFERENCES  ICSPROD.IOPEN_APPLICATIONS(COD_APPLICATION)
);

ALTER TABLE  ICSPROD.IOPEN_APPLICATION_DOCS MODIFY TIP_DOC VARCHAR2(100);
ALTER TABLE  ICSPROD.IOPEN_APPLICATION_DOCS ADD  CONTENT_TYPE VARCHAR2(100);
ALTER TABLE  ICSPROD.IOPEN_APPLICATION_DOCS ADD  CONTENT_CLASS VARCHAR2(30);

CREATE PUBLIC SYNONYM IOPEN_APPLICATION_DOCS FOR ICSPROD.IOPEN_APPLICATION_DOCS;

GRANT ALL ON  ICSPROD.IOPEN_APPLICATION_DOCS TO  ICSPROD;


-----------------------------APPLICATION TYPE & CUSTOMER TYPE MAPPING ---------
--DROP TABLE TIP_CLI_TIP_SOLIC_MAPPING;

CREATE TABLE ICSPROD.TIP_CLI_TIP_SOLIC_MAPPING(
    F_ACTUAL DATE  NOT NULL,
    USUARIO VARCHAR2(30)  NOT NULL,
    PROGRAMA VARCHAR2(15) NOT NULL,
    TIP_CLI VARCHAR2(10) NOT NULL,
    TIP_SOLIC VARCHAR2(10) NOT NULL,
    PRIMARY KEY (TIP_CLI, TIP_SOLIC)
);

CREATE PUBLIC SYNONYM TIP_CLI_TIP_SOLIC_MAPPING FOR ICSPROD.TIP_CLI_TIP_SOLIC_MAPPING;

GRANT ALL ON  ICSPROD.TIP_CLI_TIP_SOLIC_MAPPING TO  ICSPROD;

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC110','32110','UMESCI-313');

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC410','32410','UMESCI-313');

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC310','32322','UMESCI-313');

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC320','32310','UMESCI-313');

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC410','32222','UMESCI-313');

INSERT INTO TIP_CLI_TIP_SOLIC_MAPPING (F_ACTUAL, PROGRAMA, TIP_CLI, TIP_SOLIC, USUARIO)
VALUES(SYSDATE,'MANUAL','TC210','32210','UMESCI-313');


/*IOPEN APPLICATION STATUSES*/
INSERT INTO ESTADOS (USUARIO, F_ACTUAL, PROGRAMA, ESTADO, DESC_EST, DESC_EST_DET, DESC_EST_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
SELECT 'MANUAL', SYSDATE, 'IOPEN', 'IA001', 'PENDING REVIEW', 'PENDING REVIEW', 'PENDING REVIEW','SV100','PD100',1 FROM DUAL
UNION
SELECT 'MANUAL', SYSDATE, 'IOPEN', 'IA002', 'APPROVED', 'APPROVED', 'APPROVED','SV100','PD100',1 FROM DUAL
UNION
SELECT 'MANUAL', SYSDATE, 'IOPEN', 'IA003', 'REJECTED', 'REJECTED', 'REJECTED','SV100','PD100',1 FROM DUAL
UNION
SELECT 'MANUAL', SYSDATE, 'IOPEN', 'IA004', 'INVALID DOCUMENTS', 'INVALID DOCUMENTS', 'REJECTED','SV100','PD100',1 FROM DUAL
UNION
SELECT 'MANUAL', SYSDATE, 'IOPEN', 'IA010', 'CANCELLED', 'CANCELLED', 'CANCELLED','SV100','PD100',1 FROM DUAL
;

-------------------------FOR FORGET PASSWORD ACTIVATION---------------------------------------------
CREATE TABLE ICSPROD.PASSWORD_RESET_TOKEN (
TOKEN_ID NUMBER(9) PRIMARY KEY,
TOKEN VARCHAR2(100) NOT NULL,
EXPIRE_DATE DATE NOT NULL,
USERNAME VARCHAR2(100) NOT NULL
);

ALTER TABLE ICSPROD.PASSWORD_RESET_TOKEN MODIFY TOKEN VARCHAR2(100);

DROP PUBLIC SYNONYM PASSWORD_RESET_TOKEN;

CREATE PUBLIC SYNONYM PASSWORD_RESET_TOKEN FOR ICSPROD.PASSWORD_RESET_TOKEN;

GRANT ALL ON  ICSPROD.PASSWORD_RESET_TOKEN TO  ICSPROD;

CREATE SEQUENCE ICSPROD.TOKEN_ID
  START WITH 1000
  MAXVALUE 999999999
  MINVALUE 1000
  CYCLE
  CACHE 20
  NOORDER;

CREATE PUBLIC SYNONYM TOKEN_ID FOR ICSPROD.TOKEN_ID;

GRANT ALL ON  ICSPROD.TOKEN_ID TO  ICSPROD;

-------------------------IOPEN APPLICATION TRAILS---------------------------------------
CREATE TABLE ICSPROD.IOPEN_APPLICATION_STATUSES (
    COD_APPLICATION_STATUS NUMBER PRIMARY KEY,
    USUARIO VARCHAR2(100) NOT NULL,
    F_ACTUAL DATE NOT NULL,
    COD_APPLICATION VARCHAR2(30),
    EST_STATUS VARCHAR2(10),
    STATUS_DATE DATE,
    STATUS_BY VARCHAR2(100)    
);

CREATE PUBLIC SYNONYM IOPEN_APPLICATION_STATUSES FOR ICSPROD.IOPEN_APPLICATION_STATUSES;

GRANT ALL ON  ICSPROD.IOPEN_APPLICATION_STATUSES TO  ICSPROD;

CREATE SEQUENCE ICSPROD.COD_APPLICATION_STATUS
  START WITH 1000
  MAXVALUE 999999999
  MINVALUE 1000
  CYCLE
  CACHE 20
  NOORDER;

CREATE PUBLIC SYNONYM COD_APPLICATION_STATUS FOR ICSPROD.COD_APPLICATION_STATUS;

GRANT ALL ON  ICSPROD.COD_APPLICATION_STATUS TO  ICSPROD;

DROP TABLE ICSPROD.IOPEN_APPLICATION_MESSAGES;

CREATE TABLE ICSPROD.IOPEN_APPLICATION_MESSAGES(
    USUARIO VARCHAR2 (100) NOT NULL,
    F_ACTUAL DATE NOT NULL,
    SEC_ID NUMBER(9) NOT NULL,
    COD_APPLICATION NUMBER(9) NOT NULL,
    EXPEDIENTE_ESTADO VARCHAR2(5) NOT NULL,
    MESSAGE_SENT CHAR(1) NOT NULL,
    PRIMARY KEY (COD_APPLICATION,SEC_ID)
);

CREATE PUBLIC SYNONYM IOPEN_APPLICATION_MESSAGES FOR ICSPROD.IOPEN_APPLICATION_MESSAGES;

GRANT ALL ON  ICSPROD.IOPEN_APPLICATION_MESSAGES TO  ICSPROD;

-------------------------------------------------------------------------------------------------
DROP TABLE INSPECTION_RESULTS;

CREATE TABLE ICSPROD. INSPECTION_RESULTS(
OBJECTID    varchar2(100) PRIMARY KEY,
WorkRequestID    varchar2(100),
TxLocationNo   varchar2(100), 
TxName    varchar2(100),
Circuit    varchar2(100),
TxRating    varchar2(100),
Feeder    varchar2(100),
Voltage    varchar2(100),
LoadingRed    varchar2(100),
LoadingYellow    varchar2(100),
LoadingBlue    varchar2(100),
TotalLoading    varchar2(100),
LoadingOver90Percent    varchar2(100),
CustomerType    varchar2(100),
DistancefromTx varchar2(100),
RightofWay varchar2(100),
PreviousConnection    varchar2(100),
PreviousAccNo    varchar2(100),
ProcessRequestA    varchar2(100),
DenyRequestA    varchar2(100),
Impedance    varchar2(100),
LoopImpedance    varchar2(100),
CapacityRequested    varchar2(100),
PhasesRequested    varchar2(100),
DeclaredLoadAbove40kVA    varchar2(100),
AvailableCapLessThan10Perc   varchar2(100), 
ProceedWithServiceConnection    varchar2(100),
WaitforTxInjection    varchar2(100),
PurchaseTx    varchar2(100),
ServiceConnectionHalted    varchar2(100),
MVVoltage    varchar2(100),
MVLength    varchar2(100),
ProposedTxRating    varchar2(100),
Phase3Length    varchar2(100),
Phase1Length    varchar2(100),
SolidalLength    varchar2(100),
NoofMeters    varchar2(100),
NoofPoles    varchar2(100),
Approval    varchar2(100),
NearestCustomer   varchar2(100), 
VoltageNearestCustomer    varchar2(100),
Overhead    varchar2(100),
Underground    varchar2(100),
Openwire    varchar2(100),
ABC    varchar2(100),
Phase1Tx    varchar2(100),
Phase3Tx    varchar2(100),
X    varchar2(100),
Y    varchar2(100),
UmemeDistr    varchar2(100),
CapturedBy    varchar2(100),
INSPECTION_DATE    varchar2(100),
INSPECTION_TIME    varchar2(100),
Remarks varchar2(100)
);

CREATE PUBLIC SYNONYM INSPECTION_RESULTS FOR ICSPROD.INSPECTION_RESULTS;

GRANT ALL ON  ICSPROD.INSPECTION_RESULTS TO  ICSPROD;


--------------------------inspection result ics project type mapping ----------------------
CREATE TABLE ICSPROD.INSPECTION_RESULT_TIP_OBRA (
    USUARIO VARCHAR2(100),
    F_ACTUAL DATE,
    PHASES_REQUESTED VARCHAR2(30),
    MIN_NO_OF_POLES NUMBER,
    MIN_NO_OF_METERS NUMBER,
    MAX_NO_OF_POLES NUMBER,
    MAX_NO_OF_METERS NUMBER,
    TIP_OBRA VARCHAR2(5) PRIMARY KEY
);


CREATE PUBLIC SYNONYM INSPECTION_RESULT_TIP_OBRA FOR ICSPROD.INSPECTION_RESULT_TIP_OBRA;

GRANT ALL ON  ICSPROD.INSPECTION_RESULT_TIP_OBRA TO  ICSPROD;

Insert into ICSPROD.INSPECTION_RESULT_TIP_OBRA
   (PHASES_REQUESTED, MIN_NO_OF_POLES, MIN_NO_OF_METERS, MAX_NO_OF_POLES, MAX_NO_OF_METERS, TIP_OBRA)
 Values
   ('SINGLE PHASE', 0, 0, 
    0, 0, '01211');
Insert into ICSPROD.INSPECTION_RESULT_TIP_OBRA
   (PHASES_REQUESTED, MIN_NO_OF_POLES, MIN_NO_OF_METERS, MAX_NO_OF_POLES, MAX_NO_OF_METERS, TIP_OBRA)
 Values
   ('SINGLE PHASE', 0, 1, 
    0, 30, '01212');
Insert into ICSPROD.INSPECTION_RESULT_TIP_OBRA
   (PHASES_REQUESTED, MIN_NO_OF_POLES, MIN_NO_OF_METERS, MAX_NO_OF_POLES, MAX_NO_OF_METERS, TIP_OBRA)
 Values
   ('SINGLE PHASE', 0, 30, 
    0, 35, '01213');
Insert into ICSPROD.INSPECTION_RESULT_TIP_OBRA
   (PHASES_REQUESTED, MIN_NO_OF_POLES, MIN_NO_OF_METERS, MAX_NO_OF_POLES, MAX_NO_OF_METERS, TIP_OBRA)
 Values
   ('SINGLE PHASE', 1, 35, 
    1, 99, '01214');
    
    
------------------------- inspection result ics WORK REQUEST type mapping ------------------------------------------
    CREATE TABLE ICSPROD.INSPECTION_RESULT_TIP_SOLIC (
    USUARIO VARCHAR2(100),
    F_ACTUAL DATE,
    CUSTOMERTYPE VARCHAR2(30),
    TIP_SOLIC VARCHAR2(5) PRIMARY KEY
    );


CREATE PUBLIC SYNONYM INSPECTION_RESULT_TIP_SOLIC FOR ICSPROD.INSPECTION_RESULT_TIP_SOLIC;

GRANT ALL ON  ICSPROD.INSPECTION_RESULT_TIP_SOLIC TO  ICSPROD;


Insert into ICSPROD.INSPECTION_RESULT_TIP_SOLIC
   (USUARIO, F_ACTUAL, CUSTOMERTYPE, TIP_SOLIC)
 Values
   ('MANUAL', TO_DATE('10/19/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'DOMESTIC', '32110');

Insert into ICSPROD.INSPECTION_RESULT_TIP_SOLIC
   (USUARIO, F_ACTUAL, CUSTOMERTYPE, TIP_SOLIC)
 Values
   ('MANUAL', TO_DATE('10/19/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'COMMERCIAL', '32410');



    
-----------------------REJECT REASONS -------------------------------------------------------

Insert into ICSPROD.CODIGOS
   (USUARIO, F_ACTUAL, PROGRAMA, COD, DESC_COD, DESC_COD_DET, DESC_COD_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
 Values
   ('IOPEN', SYSDATE, 'MANUAL', 'IR001', 'INVALID DOCUMENTS', 
    ' ', ' ', 'SV100', 'PD100', 1);
    
Insert into ICSPROD.CODIGOS
   (USUARIO, F_ACTUAL, PROGRAMA, COD, DESC_COD, DESC_COD_DET, DESC_COD_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
Values
 ('IOPEN', SYSDATE, 'MANUAL', 'IR002', 'WRONG LOCATION DETAILS', 
    ' ', ' ', 'SV100', 'PD100', 1);
    
COMMIT;



--------------------------

CREATE TABLE ICSPROD.IOPEN_APPLICATION_STAGES (
    ESTADO VARCHAR2(6) PRIMARY KEY,
    SEQ_NUMBER NUMBER (3),
    STAGE_COMMENTS VARCHAR2(300),
    F_ACTUAL DATE,
    USUARIO VARCHAR2(100),
    PROGRAMA VARCHAR2(30)    
);

ALTER TABLE ICSPROD.IOPEN_APPLICATION_STAGES MODIFY  SEQ_NUMBER NUMBER (3);

CREATE PUBLIC SYNONYM IOPEN_APPLICATION_STAGES FOR ICSPROD.IOPEN_APPLICATION_STAGES;

GRANT ALL ON  ICSPROD.IOPEN_APPLICATION_STAGES TO  ICSPROD;


Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17001', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
   Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17005', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
   Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17014', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
     Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17020', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
     Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17011', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
     Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17012', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
        Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17004', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
        Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17013', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
           Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17019', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
              Insert into ICSPROD.IOPEN_APPLICATION_STAGES
   (ESTADO, SEQ_NUMBER, F_ACTUAL, USUARIO, PROGRAMA)
 Values
   ('17015', 1, TO_DATE('10/26/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'MANUAL');
   
   
DROP TABLE iopen_district_contacts;

create table ICSPROD.iopen_district_contacts(
    COD_DEPTO VARCHAR2(6) PRIMARY KEY,
    EMAIL VARCHAR2(100),
    PHONE_CONTACT VARCHAR2(20),
    USUARIO VARCHAR2(30),
    PROGRAMA VARCHAR2(30),
    F_ACTUAL DATE
    );

CREATE PUBLIC SYNONYM iopen_district_contacts FOR ICSPROD.iopen_district_contacts;

GRANT ALL ON  ICSPROD.iopen_district_contacts TO  ICSPROD;

CREATE TABLE ICSPROD.IOPEN_PARAMETERS;

DROP PUBLIC SYNONYM ACO_SUM;

CREATE PUBLIC SYNONYM ACO_SUM FOR IMSPROD.ACO_SUM@IMS;
CREATE PUBLIC SYNONYM GI_AVISOS FOR IMSPROD.GI_AVISOS@IMS;
CREATE PUBLIC SYNONYM GI_AVISOS_INSTALACION FOR IMSPROD.GI_AVISOS_INSTALACION@IMS;

CREATE PUBLIC SYNONYM GI_MESSAGES FOR IMSPROD.GI_MESSAGES@IMS;
CREATE PUBLIC SYNONYM GI_OT FOR IMSPROD.GI_OT@IMS;
CREATE PUBLIC SYNONYM GI_T_INT_HORARIO FOR IMSPROD.GI_T_INT_HORARIO@IMS;

DROP PUBLIC SYNONYM GI_T_TIP_AVISO;

CREATE PUBLIC SYNONYM GI_T_TIP_AVISO FOR IMSPROD.GI_T_TIP_AVISO@IMS;
CREATE PUBLIC SYNONYM GI_T_ULTIMO FOR IMSPROD.GI_T_ULTIMO@IMS;

DROP PUBLIC SYNONYM SGD_ACOMETIDA;

CREATE PUBLIC SYNONYM SGD_ACOMETIDA FOR IMSPROD.SGD_ACOMETIDA@IMS;
DROP PUBLIC SYNONYM SGD_CENTRO;
CREATE PUBLIC SYNONYM SGD_CENTRO FOR DCSPROD.SGD_CENTRO@IMS;
DROP PUBLIC SYNONYM SGD_INCIDENCIA;
CREATE PUBLIC SYNONYM SGD_INCIDENCIA FOR DCSPROD.SGD_INCIDENCIA@IMS;
CREATE PUBLIC SYNONYM SGD_RELACION_CENTRO FOR IMSPROD.SGD_RELACION_CENTRO@IMS;
DROP PUBLIC SYNONYM SGD_VALOR;
CREATE PUBLIC SYNONYM SGD_VALOR FOR DCSPROD.SGD_VALOR@IMS;

-----------phase 1-2 additions-------------------
create table ICSPROD.IOPEN_UNICOM_CONTACTS(
    COD_UNICOM VARCHAR2(6) PRIMARY KEY,
    EMAIL VARCHAR2(100),
    PHONE_CONTACT VARCHAR2(20),
    PHONE_CONTACT2 VARCHAR2(20),
    PHYSICAL_ADDRESS VARCHAR2(50),
    USUARIO VARCHAR2(30),
    PROGRAMA VARCHAR2(30),
    F_ACTUAL DATE
    );

ALTER TABLE ICSPROD.IOPEN_UNICOM_CONTACTS MODIFY(PHYSICAL_ADDRESS VARCHAR2(200));

CREATE PUBLIC SYNONYM IOPEN_UNICOM_CONTACTS FOR ICSPROD.IOPEN_UNICOM_CONTACTS;

GRANT ALL ON  ICSPROD.IOPEN_UNICOM_CONTACTS TO  ICSPROD;

INSERT INTO IOPEN_UNICOM_CONTACTS (COD_UNICOM, EMAIL, PHONE_CONTACT, PHONE_CONTACT2, PHYSICAL_ADDRESS, USUARIO, PROGRAMA, F_ACTUAL)
SELECT COD_UNICOM,' ',' ',' ',' ','IOPEN','IOPEN',SYSDATE FROM UNICOM WHERE NOM_UNICOM LIKE 'CSC%';


UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'banda@umeme.co.ug', PHONE_CONTACT = '0776 180 020', PHONE_CONTACT2 = '0312 360 722', PHYSICAL_ADDRESS = 'Plot 1-2 Enterprise Close' WHERE COD_UNICOM = '1001';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'bombo@umeme.co.ug', PHONE_CONTACT = '0776 180 157', PHONE_CONTACT2 = '0312 360 672', PHYSICAL_ADDRESS = 'Plot 12 Kalangala Road, Bombo' WHERE COD_UNICOM = '2007';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'bushenyi@umeme.co.ug', PHONE_CONTACT = '0776 180 105', PHONE_CONTACT2 = '0200-902580', PHYSICAL_ADDRESS = 'Plot 76 Rwabutongo Cell' WHERE COD_UNICOM = '2105';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'entebbe@umeme.co.ug', PHONE_CONTACT = '0776 180 143', PHONE_CONTACT2 = '0312 360 755', PHYSICAL_ADDRESS = 'Plot 26 FRV 369 Folio 22' WHERE COD_UNICOM = '1004';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'fortportal@umeme.co.ug', PHONE_CONTACT = '0776 180 099', PHONE_CONTACT2 = '0312 360 471', PHYSICAL_ADDRESS = 'Plot 31 Magambo Street' WHERE COD_UNICOM = '2108';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'gulu@umeme.co.ug', PHONE_CONTACT = '0776 180168', PHONE_CONTACT2 = '0312 360 778', PHYSICAL_ADDRESS = 'Plot 28 Gulu Street' WHERE COD_UNICOM = '2102';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'hoima@umeme.co.ug', PHONE_CONTACT = '0776 180149', PHONE_CONTACT2 = '0312 360 210', PHYSICAL_ADDRESS = 'Plot 10 Main Street' WHERE COD_UNICOM = '2006';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'iganga@umeme.co.ug', PHONE_CONTACT = '0776 180 120', PHONE_CONTACT2 = '0312 360 325', PHYSICAL_ADDRESS = '109 Old Market Street' WHERE COD_UNICOM = '2001';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'jinja@umeme.co.ug', PHONE_CONTACT = '0776 180 144', PHONE_CONTACT2 = '0312 360 311', PHYSICAL_ADDRESS = 'Plot 26 Kampala Rd / Plot 14/16 Oboja Road FRV 201 F2' WHERE COD_UNICOM = '2000';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'kabalagala@umeme.co.ug', PHONE_CONTACT = '0776 180 164', PHONE_CONTACT2 = '0312 360 633', PHYSICAL_ADDRESS = 'Plot 1207 Gaba Road, Nsambya' WHERE COD_UNICOM = '1009';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'kabale@umeme.co.ug', PHONE_CONTACT = '0776 180 012', PHONE_CONTACT2 = '0486 423 673', PHYSICAL_ADDRESS = 'Plot 127 Kabale Rd / LRV 544 Folio 8' WHERE COD_UNICOM = '2106';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'kasese@umeme.co.ug', PHONE_CONTACT = '0312-360437', PHONE_CONTACT2 = '0776-180062', PHYSICAL_ADDRESS = 'Plot 39�Block 425 Margarita Road' WHERE COD_UNICOM = '2107';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'kitintale@umeme.co.ug', PHONE_CONTACT = '0776 180 158', PHONE_CONTACT2 = '0312 360 707', PHYSICAL_ADDRESS = 'Plot 243 Luzira-Kitintale' WHERE COD_UNICOM = '1006';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'lira@umeme.co.ug', PHONE_CONTACT = '0776 180051', PHONE_CONTACT2 = '0312 360 234', PHYSICAL_ADDRESS = 'Plot 1 Maruzi Road' WHERE COD_UNICOM = '2100';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'masaka@umeme.co.ug', PHONE_CONTACT = '0776 180 117', PHONE_CONTACT2 = '0312 360 450', PHYSICAL_ADDRESS = 'Plot 30 Kampala Road' WHERE COD_UNICOM = '2200';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'mbale@umeme.co.ug', PHONE_CONTACT = '0776 180 174', PHONE_CONTACT2 = '0312 360 355', PHYSICAL_ADDRESS = 'Plot 42 Cathedral Avenue' WHERE COD_UNICOM = '2202';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'mbarara@umeme.co.ug', PHONE_CONTACT = '0776 180 152', PHONE_CONTACT2 = '0312 360 463', PHYSICAL_ADDRESS = 'Plot 19 High Street' WHERE COD_UNICOM = '2104';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'mityana@umeme.co.ug', PHONE_CONTACT = '0776 180 163', PHONE_CONTACT2 = '0312 360 698', PHYSICAL_ADDRESS = 'Plot 39 Mityana Road' WHERE COD_UNICOM = '2008';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'mukono@umeme.co.ug', PHONE_CONTACT = '0776 180 150', PHONE_CONTACT2 = '0312 360 797', PHYSICAL_ADDRESS = 'Plot 98-102 Kampala Road' WHERE COD_UNICOM = '2004';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'najja@umeme.co.ug', PHONE_CONTACT = '0776 180 047', PHONE_CONTACT2 = '0312 360 732', PHYSICAL_ADDRESS = '2nd Floor, Freedom City Mall, Namasuba, Entebbe Road' WHERE COD_UNICOM = '1003';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'tororo@umeme.co.ug', PHONE_CONTACT = '0776 180018', PHONE_CONTACT2 = '0454 445 162/160', PHYSICAL_ADDRESS = '1A AND 1B Bazaar Street' WHERE COD_UNICOM = '2203';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'nateete@umeme.co.ug', PHONE_CONTACT = '0776 180086', PHONE_CONTACT2 = '0312 360 725', PHYSICAL_ADDRESS = 'Plot 2449 Block 8 Natete' WHERE COD_UNICOM = '1002';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'nakulabye@umeme.co.ug', PHONE_CONTACT = '0776 180125', PHONE_CONTACT2 = '0312 360 730', PHYSICAL_ADDRESS = 'Plot 419 Kibuga, Mengo' WHERE COD_UNICOM = '1007';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'wandegeya@umeme.co.ug', PHONE_CONTACT = '0776 180 175', PHONE_CONTACT2 = '0312 360 643', PHYSICAL_ADDRESS = 'Plot 1064 AND 956, Bombo Road' WHERE COD_UNICOM = '1005';
UPDATE IOPEN_UNICOM_CONTACTS SET EMAIL = 'metro@umeme.co.ug', PHONE_CONTACT = '0776 180 169', PHONE_CONTACT2 = '0312 360 658', PHYSICAL_ADDRESS = 'Plot 5 Pilkington Road' WHERE COD_UNICOM = '1000';

-----------------BILLS ---------------------------------------
Insert into ICSPROD.CODIGOS
   (USUARIO, F_ACTUAL, PROGRAMA, COD, DESC_COD, DESC_COD_DET, DESC_COD_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
 Values
   ('IOPEN', SYSDATE, 'IOPEN', 'GE600', 'BILL STATUSES DISPLAYED ON IOPEN BILL LIST', 
    ' ', ' ', 'SV100', 'PD100', 1);
COMMIT;


Insert into ICSPROD.GRUPO_EST
   (USUARIO, F_ACTUAL, PROGRAMA, CO_GRUPO, EST_REC, ORDEN_GI)
Values
   ('IOPEN', SYSDATE, 'IOPEN', 'GE600', 'ER020',  0);
   
Insert into ICSPROD.GRUPO_EST
   (USUARIO, F_ACTUAL, PROGRAMA, CO_GRUPO, EST_REC, ORDEN_GI)
Values
   ('IOPEN', SYSDATE, 'IOPEN', 'GE600', 'ER310',  0);
    
COMMIT;

--------------group for consumption consuption type to display on the consumption listing ----------------------------

Insert into ICSPROD.CODIGOS
   (USUARIO, F_ACTUAL, PROGRAMA, COD, DESC_COD, DESC_COD_DET, DESC_COD_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
 Values
   ('IOPEN', SYSDATE, 'IOPEN', 'AP001', 'CONSUMPTION READING TYPE TO DISPLAY ON IOPEN CONSUMPTION LIST', 
    ' ', ' ', 'SV100', 'PD100', 1);
COMMIT;


Insert into ICSPROD.GRUPO_EST
   (USUARIO, F_ACTUAL, PROGRAMA, CO_GRUPO, EST_REC, ORDEN_GI)
Values
   ('IOPEN', SYSDATE, 'IOPEN', 'AP001', 'RA000',  0);
   
Insert into ICSPROD.GRUPO_EST
   (USUARIO, F_ACTUAL, PROGRAMA, CO_GRUPO, EST_REC, ORDEN_GI)
Values
   ('IOPEN', SYSDATE, 'IOPEN', 'AP001', 'RA005',  0);
    
COMMIT;
---------------------------------------------
Insert into ICSPROD.CODIGOS
   (USUARIO, F_ACTUAL, PROGRAMA, COD, DESC_COD, DESC_COD_DET, DESC_COD_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)
 Values
   ('IOPEN', SYSDATE, 'IOPEN', 'AP002', 'CONSUMPTION READING STATUS TO DISPLAY ON IOPEN CONSUMPTION LIST', 
    ' ', ' ', 'SV100', 'PD100', 1);
COMMIT;

Insert into ICSPROD.GRUPO_EST
   (USUARIO, F_ACTUAL, PROGRAMA, CO_GRUPO, EST_REC, ORDEN_GI)
Values
   ('IOPEN', SYSDATE, 'IOPEN', 'AP002', 'US001',  0);

    
COMMIT;
------------------------------------------------------------------------------------------------------------
ALTER TABLE ICSPROD.IOPEN_APPLICATION_DOCS ADD ( TAC              CHAR(1 CHAR)                 DEFAULT '0'                    NOT NULL);

ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD (DISTRICT_DESC  VARCHAR2(30 BYTE) DEFAULT ' '  NOT NULL,
TOWN_DESC VARCHAR2(100 BYTE) DEFAULT ' '   NOT NULL,
COUNTY_DESC VARCHAR2(100 BYTE)  DEFAULT ' '  NOT NULL,
SUB_COUNTY_DESC VARCHAR2(100 BYTE)  DEFAULT ' '  NOT NULL,
VILLAGE_DESC VARCHAR2(100 BYTE)  DEFAULT ' '  NOT NULL,
STREET_DESC VARCHAR2(100 BYTE) DEFAULT ' '   NOT NULL,
DIRECTIONS_DESC VARCHAR2(200 BYTE)  DEFAULT ' '  NOT NULL);
COMMIT;

---------------------------------------------------------------------------------------------------------------

UPDATE IOPEN_APPLICATION_STAGES SET STAGE_COMMENTS = 'Quotation Pending.Awaiting The Engineers to Design Your connection' 
WHERE ESTADO = '17012';
COMMIT;

---------------------------------------------------------------------------------------------------------------
--THE UMEME DB DID NOT HAVE THE LIKE 'IA%' VALUES IN ESTADOS
BEGIN
Insert into ESTADOS
   (USUARIO, F_ACTUAL, PROGRAMA, ESTADO, DESC_EST, 
    DESC_EST_DET, DESC_EST_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)  Values
   ('MANUAL', TO_DATE('09/21/2015 15:25:13', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'IA001', 'PENDING REVIEW', 
    'PENDING REVIEW', 'PENDING REVIEW', 'SV100', 'PD100', 1); Insert into ESTADOS
   (USUARIO, F_ACTUAL, PROGRAMA, ESTADO, DESC_EST, 
    DESC_EST_DET, DESC_EST_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)  Values
   ('MANUAL', TO_DATE('09/21/2015 15:25:13', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'IA002', 'APPROVED', 
    'APPROVED', 'APPROVED', 'SV100', 'PD100', 1); Insert into ESTADOS
   (USUARIO, F_ACTUAL, PROGRAMA, ESTADO, DESC_EST, 
    DESC_EST_DET, DESC_EST_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)  Values
   ('MANUAL', TO_DATE('09/23/2015 16:16:15', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'IA003', 'REJECTED', 
    'REJECTED', 'REJECTED', 'SV100', 'PD100', 1); Insert into ESTADOS
   (USUARIO, F_ACTUAL, PROGRAMA, ESTADO, DESC_EST, 
    DESC_EST_DET, DESC_EST_SK, TIP_SERV, TIP_PRODUCTO, IND_IN_USE)  Values
   ('MANUAL', TO_DATE('09/29/2015 15:03:04', 'MM/DD/YYYY HH24:MI:SS'), 'IOPEN', 'IA010', 'CANCELLED', 
    'CANCELLED', 'CANCELLED', 'SV100', 'PD100', 1); COMMIT;
exception
  when DUP_VAL_ON_INDEX
  then ROLLBACK;
end;

-------------------------------------------------------------------------------------------------------------
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS ADD (INTERMEDIATE_SUBMIT NUMBER(1)  DEFAULT 0 NOT NULL);
COMMIT;
--------------------------------------------------------------------------------------------------------------
ALTER TABLE ICSPROD.IOPEN_APPLICATIONS
ADD (GPS VARCHAR2(255 BYTE));

COMMENT ON COLUMN 
ICSPROD.IOPEN_APPLICATIONS.GPS IS 
'Holds the GPS data sent by the GIS application';
COMMIT;
---------------------------------------------------------------------------------------------------------------
--UMESC-732
CREATE SEQUENCE GIS_MAPPING;
CREATE OR REPLACE TRIGGER GIS_MAPPING_ON_INSERT
  BEFORE INSERT ON GIS_IOPEN_MAPPING
  FOR EACH ROW
BEGIN
  SELECT GIS_MAPPING.nextval
  INTO :new.id
  FROM dual;
END;
ALTER TABLE ICSPROD.GIS_IOPEN_MAPPING
 DROP PRIMARY KEY CASCADE;

DROP TABLE ICSPROD.GIS_IOPEN_MAPPING CASCADE CONSTRAINTS;

CREATE TABLE ICSPROD.GIS_IOPEN_MAPPING
(
  ID           INTEGER                          NOT NULL,
  CODE         VARCHAR2(50 BYTE)                NOT NULL,
  DESCRIPTION  VARCHAR2(125 BYTE)               NOT NULL
)
TABLESPACE USERS
RESULT_CACHE (MODE DEFAULT)
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX ICSPROD.GIS_IOPEN_MAPPING_PK ON UFA01026.GIS_IOPEN_MAPPING
(ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX ICSPROD.MAP_DESC ON ICSPROD.GIS_IOPEN_MAPPING
(DESCRIPTION)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOPARALLEL;


CREATE OR REPLACE TRIGGER ICSPROD.GIS_MAPPING_ON_INSERT
  BEFORE INSERT ON ICSPROD.GIS_IOPEN_MAPPING
  FOR EACH ROW
BEGIN
  SELECT GIS_MAPPING.nextval
  INTO :new.id
  FROM dual;
END;
/


ALTER TABLE ICSPROD.GIS_IOPEN_MAPPING ADD (
  CONSTRAINT GIS_IOPEN_MAPPING_PK
  PRIMARY KEY
  (ID)
  USING INDEX ICSPROD.GIS_IOPEN_MAPPING_PK
  ENABLE VALIDATE);
  SET DEFINE OFF;
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (6, '17011', 'FAILED INSPECTION');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (7, '17014', 'RE-INSPECTION PAID');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (8, '17005', 'INSPECTION PAID');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (9, '17009', 'PASSED INSPECTION');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (10, '17020', 'INSPECTION PASSED');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (11, '01210', 'STANDARD CONNECTIONS');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (12, '01211', 'SINGLE PHASE - NO POLE LOOPING');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (13, '01212', 'SINGLE PHASE - NO POLE LESS THAN 30 METRES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (14, '01213', 'SINGLE PHASE - NO POLE UP TO 35 METRES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (15, '01214', 'SINGLE PHASE - ONE POLE ABOVE 35 METRES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (16, '01215', 'PREPAYMENT CONNECTION - DO NOT USE');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (17, '01218', 'OBA - OUTPUT BASED AID');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (18, '01221', 'THREE PHASE SERVICES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (19, '01222', 'KVA/TIME OF USE SERVICES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (20, '01223', 'CAPITAL DEVELOPMENT');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (21, '01224', 'RE-ROUTINGS');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (22, '01225', 'TARIFF CHANGE');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (23, '01226', 'TEMPORARY SERVICES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (24, '01227', 'SINGLE PHASE - MORE THAN ONE POLE');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (25, '01228', 'GROUP SCHEMES');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (26, '01229', 'CONTRACTOR JOB');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (27, '32110', '100 - DOMESTIC');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (28, '32111', '610 - DOMESTIC (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (29, '32210', '500 - STREET LIGHTING');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (30, '32211', '520 - STREET LIGHTING(TOU)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (31, '32222', '222 - COMMMERCIAL - TOU');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (32, '32310', '310 - LARGE INDUSTRIAL');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (33, '32311', '631 - LARGE INDUSTRIAL (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (34, '32320', '320 - OFF PEAK LARGE INDUSTRIAL');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (35, '32321', '632 - OFF PEAK LARGE INDUSTRIAL (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (36, '32322', '410 - MEDIUM INDUSTRIAL');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (37, '32323', '641 - MEDIUM INDUSTRIAL (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (38, '32331', '420 - OFF PEAK MEDIUM INDUSTRIAL');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (39, '32332', '642 - OFF PEAK MEDIUM INDUSTRIAL (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (40, '32410', '200 - COMMERCIAL');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (41, '32420', '620 - COMMERCIAL (DIPLOMAT)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (42, '32422', '422 - MEDIUM INDUST - TOU');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (43, '32634', '322 - LARGE INDUSTRY - HV');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (44, '32635', 'PREPAYMENT - DOMESTIC');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (45, '32636', 'PREPAYMENT - COMMERCIAL(SINGLE PHASE)');
Insert into GIS_IOPEN_MAPPING
   (ID, CODE, DESCRIPTION)
 Values
   (46, '32637', 'PREPAYMENT - COMMERCIAL(THREE PHASE)');
COMMIT;
--------------------------------------------------------------------
