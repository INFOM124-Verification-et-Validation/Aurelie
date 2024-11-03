// Decision table

// |                 |              |         |             |        |
// |-----------------|--------------|---------|-------------|--------|
// | **Collider**    | Ghost        | Player  | Player      | Player | 
// | **Collidee**    | Pellet       | Ghost   | Pellet      | Wall   |
// | **Consequence** | Pellet       | Game    | Player      | Move   |
// |                 | temporarily  | over    | gains points| fails  |
// |                 | disappears   |         | Pellet      |        |
// |                 |              |         | disappears  |        |
