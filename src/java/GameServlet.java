
import java.io.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/GameServlet"})
public final class GameServlet extends HttpServlet {

    Board board;

    @Override
    public void init(final ServletConfig config) {
        board = new Board();
        Logger.getGlobal().log(Level.INFO, "Game started!");
    }

    //this is used to create a player for each session if it the session is new
    private void validatePlayer(HttpServletRequest request) {
        HttpSession sess = request.getSession();

        if (sess.isNew()) {
            Player newPlayer = new Player();
            board.addPlayer(newPlayer); //player is added to the board.(an ID to the player
                                        //is assigned by the board)
            synchronized (sess) {
                sess.setAttribute("PLAYER", newPlayer);
            }
        }
    }
    
    //this is used to get the player ID corresponding to the current player session
    private int getPlayerID(HttpServletRequest request) {
        HttpSession sess = request.getSession();
        return ((Player) sess.getAttribute("PLAYER")).getID();
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (this) {
            String keyPress = request.getParameter("keypress");
            board.ValidateMove(getPlayerID(request), keyPress);
            notifyAll();
            Logger.getGlobal().log(Level.INFO, "Received " + keyPress);
        }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        validatePlayer(request); //creating a new player session if one doesn't already exist
        
        try (final PrintWriter out = response.getWriter()) {
            
            //sending the initial board status to the newly connected player
            out.print("data: ");
            out.println(board);
            out.println();
            
            //sending board updates continously when new update is available
            while (!Thread.interrupted()) {
                out.println();
                out.flush();
                Logger.getGlobal().log(Level.INFO, "Sent " + board);
                synchronized (this) {
                    wait();
                    out.print("data: ");
                    out.println(board);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getGlobal().log(Level.INFO, "Exiting");
        }
    }

}
