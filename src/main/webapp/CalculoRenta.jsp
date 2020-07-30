<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<jsp:useBean id="data" class="ec.edu.ups.vista.DatosController">
<jsp:setProperty name="data" property="*" />
</jsp:useBean>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <h1>Datos de Ingresos</h1>
                
                Sueldo: <jsp:getProperty name="data" property="sueldo"/><br>
                Ingesos: <jsp:getProperty name="data" property="ingreso"/><br>
                Capital: <jsp:getProperty name="data" property="capital"/><br>
                Utilidad: <jsp:getProperty name="data" property="utilidad"/><br>
                
                Total Ingresos: <jsp:getProperty name="data" property="totalIngreso"/><br>
 
                <h1>Datos de Egresos</h1>
                Alimentacion <jsp:getProperty name="data" property="alimentacion"/><br>
                Vivienda <jsp:getProperty name="data" property="vivienda"/><br>
                Educacion <jsp:getProperty name="data" property="educacion"/><br>
                Vestimeta <jsp:getProperty name="data" property="vestimenta"/><br>
                Salud <jsp:getProperty name="data" property="salud"/><br>
                
                Total Egresos: <jsp:getProperty name="data" property="totalEgresos"/><br>
                
                Base Imponible: <jsp:getProperty name="data" property="baseImponible"/><br>
                
                Total Impuestos: <jsp:getProperty name="data" property="calculoImpuestoRenta"/><br>
                
                 
        
    </body>
    
</html>