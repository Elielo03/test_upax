# test_upax

Ejercicio 1 
* Tiene las validaciones
--POST localhost:8082/api/addEmployee

{
    "name":"Eliel2",
    "lastName":"Rod2",
    "birthdate":"2000-01-02",
    "gender_id":1,
    "job_id":1
}

Ejercicio 2
a)
--GET  localhost:8082/api/getJobById
{
    "id":1
    
}
b)c)d) el lsitado de empelados y el filtro lambda estan en ese mismo endpoint y tambbien lo regresa ordenado