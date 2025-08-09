describe('Hotel landing page', () => {
  it('displays welcome message', () => {
    cy.visit('/index.html');
    cy.contains('h1', 'Hotel Surotec').should('be.visible');
  });
});
