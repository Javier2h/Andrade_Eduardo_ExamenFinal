document.addEventListener('DOMContentLoaded', function() {
    const proyectosBody = document.getElementById('proyectos-body');
    const agregarBtn = document.getElementById('agregar-proyecto');
    const limpiarBtn = document.getElementById('limpiar');
    const formulario = document.getElementById('formulario');
    const resultadoDiv = document.getElementById('resultado');
    const seleccionadosBody = document.getElementById('seleccionados-body');
    const gananciaTotalSpan = document.getElementById('ganancia-total');
    const pesoTotalSpan = document.getElementById('peso-total');

    function agregarFila(nombre = '', peso = '', ganancia = '') {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td><input type="text" name="nombre" value="${nombre}" required></td>
            <td><input type="number" name="peso" min="0" value="${peso}" required></td>
            <td><input type="number" name="ganancia" min="0" value="${ganancia}" required></td>
            <td><button type="button" class="eliminar">Eliminar</button></td>
        `;
        proyectosBody.appendChild(tr);
        tr.querySelector('.eliminar').onclick = function() {
            tr.remove();
        };
    }

    agregarBtn.onclick = function() {
        agregarFila();
    };

    limpiarBtn.onclick = function() {
        document.getElementById('capacidad').value = '';
        proyectosBody.innerHTML = '';
        resultadoDiv.style.display = 'none';
    };

    formulario.onsubmit = async function(e) {
        e.preventDefault();
        const capacidad = parseInt(document.getElementById('capacidad').value);
        const filas = proyectosBody.querySelectorAll('tr');
        const objetos = [];
        for (const fila of filas) {
            const nombre = fila.querySelector('input[name="nombre"]').value;
            const peso = parseInt(fila.querySelector('input[name="peso"]').value);
            const ganancia = parseInt(fila.querySelector('input[name="ganancia"]').value);
            if (!nombre || isNaN(peso) || isNaN(ganancia)) {
                alert('Completa todos los campos de los proyectos.');
                return;
            }
            objetos.push({ nombre, peso, ganancia });
        }
        if (isNaN(capacidad) || capacidad < 0) {
            alert('La capacidad debe ser un número positivo.');
            return;
        }
        if (objetos.length === 0) {
            alert('Agrega al menos un proyecto.');
            return;
        }
        // Llamada al backend
        try {
            const res = await fetch('http://localhost:8080/optimizar', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ capacidad, objetos })
            });
            if (!res.ok) throw new Error('Error en el servidor');
            const data = await res.json();
            mostrarResultado(data);
        } catch (err) {
            alert('No se pudo conectar con el backend.');
        }
    };

    function mostrarResultado(data) {
        resultadoDiv.style.display = 'block';
        seleccionadosBody.innerHTML = '';
        (data.seleccionados || []).forEach(nombre => {
            const tr = document.createElement('tr');
            tr.innerHTML = `<td>${nombre}</td>`;
            seleccionadosBody.appendChild(tr);
        });
        gananciaTotalSpan.textContent = data.ganancia_total;
        pesoTotalSpan.textContent = data.peso_total;
    }

    // Inicializa con una fila
    agregarFila();
});
