let miTabla = document.getElementById("miTabla");
let titulo = document.getElementById("titulo");

const getUsuario = (url, buscar) => {  
    miTabla.innerHTML ="";    
    titulo.innerHTML ="";
    //obtener elemento
    let elemento = document.getElementById(buscar);
    //obtener valor a buscar    
    let elementoBuscar = document.getElementById(buscar).value;
    // Obtiene el valor del atributo "name" del elemento
    let nameElemento = elemento.getAttribute('name');
    
    let fullUrl = `http://${url}?${nameElemento}=${elementoBuscar}`;        

    fetch(fullUrl)
    .then(response => response.json())
    .then(data => {
        // Asigna los datos obtenidos a la variable datosTabla
        titulo.innerHTML = data.mensaje;        
        titulo.classList.remove('text-danger');
        //obtener usuario
        let usuario = data.usuario;
        if(usuario != null){
            titulo.classList.add('text-success');
            //generar cabecera
            let cabecera = document.createElement('tr');
            let cabeceraId = document.createElement('th');
            let cabeceraName = document.createElement('th');
            let cabeceraUsername = document.createElement('th');
            let cabeceraEmail = document.createElement('th');
            let cabeceraPhone = document.createElement('th');
            let cabeceraWebsite = document.createElement('th');

            cabeceraId.textContent = '#';
            cabeceraName.textContent = 'Nombre y Apellido';
            cabeceraUsername.textContent = 'Usuario';
            cabeceraEmail.textContent = 'Email';
            cabeceraPhone.textContent = 'Teleono';
            cabeceraWebsite.textContent = 'Web Site';

            cabecera.appendChild(cabeceraId);
            cabecera.appendChild(cabeceraName);
            cabecera.appendChild(cabeceraUsername);
            cabecera.appendChild(cabeceraEmail);
            cabecera.appendChild(cabeceraPhone);
            cabecera.appendChild(cabeceraWebsite);

            miTabla.appendChild(cabecera);

            //cargar datos                
            let datos = document.createElement('tr');
            let datosId = document.createElement('td');
            let datosName = document.createElement('td');
            let datosUsername = document.createElement('td');
            let datosEmail = document.createElement('td');
            let datosPhone = document.createElement('td');
            let datosWebsite = document.createElement('td');

            datosId.textContent = usuario.id;
            datosName.textContent = usuario.name;
            datosUsername.textContent = usuario.username;
            datosEmail.textContent = usuario.email;
            datosPhone.textContent = usuario.phone;
            datosWebsite.textContent = usuario.website;

            datos.appendChild(datosId);
            datos.appendChild(datosName);
            datos.appendChild(datosUsername);
            datos.appendChild(datosEmail);
            datos.appendChild(datosPhone);
            datos.appendChild(datosWebsite);

            miTabla.appendChild(datos);        
        }else{
            titulo.classList.add('text-danger');
        }
        
    }).catch(
        error => { console.log("Se produjo un error: ", error); }
)} 

const getPokemon = (url, buscar) => {  
    miTabla.innerHTML ="";
    
    titulo.innerHTML ="";
    
    //obtener elemento
    let elemento = document.getElementById(buscar);
    //obtener valor a buscar    
    let elementoBuscar = document.getElementById(buscar).value;
    // Obtiene el valor del atributo "name" del elemento
    let nameElemento = elemento.getAttribute('name');
    
    let fullUrl = `http://${url}?${nameElemento}=${elementoBuscar}`;    
    
    fetch(fullUrl)
    .then(response => response.json())
    .then(data => {        
        titulo.innerHTML = data.mensaje;
        titulo.classList.remove('text-danger');
        let pokemon = data.pokemon;

        if(pokemon != null){
            titulo.classList.add('text-success');
            //generar cabecera
            let cabecera = document.createElement('tr');
            let cabeceraId = document.createElement('th');
            let cabeceraNombre = document.createElement('th');
            let cabeceraPeso = document.createElement('th');
            let cabeceraAltura = document.createElement('th');

            cabeceraId.textContent = '#';
            cabeceraNombre.textContent = 'Nombre';
            cabeceraPeso.textContent = 'Altura';
            cabeceraAltura.textContent = 'Peso';

            cabecera.appendChild(cabeceraId);
            cabecera.appendChild(cabeceraNombre);
            cabecera.appendChild(cabeceraPeso);
            cabecera.appendChild(cabeceraAltura);

            miTabla.appendChild(cabecera);

            //cargar datos                
            let datos = document.createElement('tr');
            let datosId = document.createElement('td');
            let datosNombre = document.createElement('td');
            let datosPeso = document.createElement('td');
            let datosAltura = document.createElement('td');

            datosId.textContent = pokemon.id;
            datosNombre.textContent = pokemon.name;
            datosPeso.textContent = pokemon.weight;
            datosAltura.textContent = pokemon.height;

            datos.appendChild(datosId);
            datos.appendChild(datosNombre);
            datos.appendChild(datosPeso);
            datos.appendChild(datosAltura);

            miTabla.appendChild(datos);                                    
        }else{
            titulo.classList.add('text-danger');
        }

    }).catch(
        error => { console.log("Se produjo un error: ", error); }
)} 

const getCovid = (url, buscar) => {  
    miTabla.innerHTML ="";    
    titulo.innerHTML ="";
    //obtener elemento
    let elemento = document.getElementById(buscar);
    //obtener valor a buscar    
    let elementoBuscar = document.getElementById(buscar).value;
    // Obtiene el valor del atributo "name" del elemento
    let nameElemento = elemento.getAttribute('name');    
    let fullUrl = `http://${url}?${nameElemento}=${elementoBuscar}`;        

    fetch(fullUrl)
    .then(response => response.json())
    .then(data => {
        // Asigna los datos obtenidos a la variable datosTabla
        titulo.innerHTML = data.mensaje;        
        titulo.classList.remove('text-danger');
        //obtener usuario
        let covid = data.covid;
        if(covid != null){
            titulo.classList.add('text-success');
            //generar cabecera
            let cabecera = document.createElement('tr');
            let cabeceraDate = document.createElement('th');
            let cabeceraDeath = document.createElement('th');
            let cabeceraHospitalized = document.createElement('th');
            let cabeceraNegative = document.createElement('th');
            let cabeceraPending = document.createElement('th');
            let cabeceraPositive = document.createElement('th');
            let cabeceraStates = document.createElement('th');
            let cabeceraTotalTestResults = document.createElement('th');

            cabeceraDate.textContent = 'Fecha';
            cabeceraDeath.textContent = 'Muertes';
            cabeceraHospitalized.textContent = 'Hospitalizados';
            cabeceraNegative.textContent = 'Negativos';
            cabeceraPending.textContent = 'Pendientes';
            cabeceraPositive.textContent = 'Positivos';
            cabeceraStates.textContent = 'Estados';
            cabeceraTotalTestResults.textContent = 'Total Testeados';

            cabecera.appendChild(cabeceraDate);
            cabecera.appendChild(cabeceraDeath);
            cabecera.appendChild(cabeceraHospitalized);
            cabecera.appendChild(cabeceraNegative);
            cabecera.appendChild(cabeceraPending);
            cabecera.appendChild(cabeceraPositive);
            cabecera.appendChild(cabeceraStates);
            cabecera.appendChild(cabeceraTotalTestResults);

            miTabla.appendChild(cabecera);

            //cargar datos                
            let datos = document.createElement('tr');
            let datosDate = document.createElement('td');
            let datosDeath = document.createElement('td');
            let datosHospitalized = document.createElement('td');
            let datosNegative = document.createElement('td');
            let datosPending = document.createElement('td');
            let datosPositive = document.createElement('td');
            let datosStates = document.createElement('td');
            let datosTotalTestResults = document.createElement('td');
    
            //datosDate.textContent = covid.date;
            datosDate.textContent = elementoBuscar;
            datosDeath.textContent = covid.death;
            datosHospitalized.textContent = covid.hospitalized;
            datosNegative.textContent = covid.negative;
            datosPending.textContent = covid.pending;
            datosPositive.textContent = covid.positive;
            datosStates.textContent = covid.states;
            datosTotalTestResults.textContent = covid.totalTestResults;

            datos.appendChild(datosDate);
            datos.appendChild(datosDeath);
            datos.appendChild(datosHospitalized);
            datos.appendChild(datosNegative);
            datos.appendChild(datosPending);
            datos.appendChild(datosPositive);
            datos.appendChild(datosStates);
            datos.appendChild(datosTotalTestResults);

            miTabla.appendChild(datos);        
        }else{
            titulo.classList.add('text-danger');
        }
        
    }).catch(
        error => { console.log("Se produjo un error: ", error); }
)} 