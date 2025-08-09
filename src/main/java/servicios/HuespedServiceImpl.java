package servicios;

import modelo.dominio.Persona;

import java.util.HashMap;
import java.util.Map;

public class HuespedServiceImpl implements PersonaInterface {

    private final Map<Integer, Persona> personas = new HashMap<>();

    @Override
    public void registrarPersona(Persona persona) {
        personas.put(persona.getId(), persona);
    }

    @Override
    public void eliminarPersona(int id) {
        personas.remove(id);
    }

    @Override
    public Persona buscarPersona(int id) {
        return personas.get(id);
    }

    @Override
    public void actualizarPersona(Persona persona) {
        personas.put(persona.getId(), persona);
    }

    @Override
    public void listarPersonas() {
        personas.values().forEach(System.out::println);
    }

    public int totalPersonas() {
        return personas.size();
    }
}
