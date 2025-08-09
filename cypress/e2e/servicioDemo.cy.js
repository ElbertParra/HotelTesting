describe('ServicioDemo', () => {
  before(() => {
    cy.exec('bash -lc "mkdir -p target/classes && javac $(find src/main/java -name \'*.java\') -d target/classes"');
  });

  it('manipula huespedes', () => {
    cy.exec('java -cp target/classes servicios.ServicioDemo huesped').its('stdout')
      .should('contain', 'Listado inicial: 1')
      .and('contain', 'Buscar 1: Juan')
      .and('contain', 'Listado final: 0');
  });

  it('manipula empleados', () => {
    cy.exec('java -cp target/classes servicios.ServicioDemo empleado').its('stdout')
      .should('contain', 'Buscar 1: Ana')
      .and('contain', 'Cargo actualizado: Gerente');
  });
});
