package com.leonet.app.controller.problemsController.listProblem;

import com.leonet.app.controller.ControllerRepositoty;
import com.leonet.app.model.Model;
import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.model.problems.itemsListProblem.ProblemList;
import com.leonet.app.model.user.UserRepository;
import com.leonet.app.view.View;
import com.leonet.app.view.home.problems.listProblem.PnItemList;
import com.leonet.app.view.home.problems.listProblem.PnListProblem;
import com.leonet.app.view.shared.Patron;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class ListProblemController extends ControllerRepositoty {
    private final String ITEMS_LIST = "ITEMS_LIST";
    private final String FLOWCHART = "FLOWCHART";
    private final String CODE = "CODE";

    public ListProblemController(Model model, View view) {
        super(model, view);
    }

    public void initProblemList(UserRepository userProfile, String type) {
        loadProblem(userProfile, type);
    }

    private void loadProblem(UserRepository userProfile, String type) {
        ProblemList pl = model.getProblems().chooseProblemList(userProfile.getNickname());
        view.getPnLeonetApp().getpContexto().updateContext(pl.getContextProblem(), pl.linesContext());
        view.getPnLeonetApp().getpContexto().updateExample(pl.getExampleProblem(), pl.linesExample());
        view.getPnLeonetApp().getpProblema().updateDefProblem(pl.getDefinitionProblem(), pl.linesDefProblem());

        switch (type) {
            case ITEMS_LIST:
                view.getPnLeonetApp().getpProblema().loadItemListProblem(pl.getItemListsArray(), pl.getIndentation());
                view.getPnLeonetApp().repaint();
                dragAndDropListener();
                break;
            case FLOWCHART:
                break;
            case CODE:
                break;
        }
        updateInfoUserHeader(userProfile.getNickname());
        updateThemeLevel(userProfile.getNickname());
    }

    private void updateThemeLevel(String nickname) {
        double startingPoint = model.getProblems().getAmountProblemSolved(nickname);

        double finalPoint = model.getProblems().getCountSubThemes(nickname);
        double increasePoint = (startingPoint / finalPoint) * 100;
        view.getPnLeonetApp().getpNivel().updateLoadingBar(increasePoint);

        String[] themeCategory = model.getProblems().getThemeCategoryInfo(nickname);
        String level = themeCategory[0];
        String theme = themeCategory[1];
        view.getPnLeonetApp().getpNivel().updateThemeInfo(level, theme);
    }

    private void updateInfoUserHeader(String nickname) {
        UserRepository user = model.getUser().getUserProfile(nickname);
        view.getPnHeader().setUserProfile(user);
        view.getPnHeader().updateInfoUser();

    }

    public void dragAndDropListener() {
        ArrayList<PnItemList> pnItemListArray = view.getPnLeonetApp().getpProblema().getPnListProblem().getPnItemListArray();

        for (PnItemList item : pnItemListArray) {
            item.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    item.screenY = e.getYOnScreen();
                    item.myY = item.getY();
                    item.setActive(true);
                    view.getPnLeonetApp().getpProblema().getPnListProblem().rearrangePanels(item);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int originalPos, finalPos, deltaY;
                    if (item.isActive()) {
                        item.setActive(false);

                        originalPos = item.myY;
                        finalPos = item.getLocation().y;
                        deltaY = finalPos / item.getHeight();

                        PnListProblem pnListProblem = view.getPnLeonetApp().getpProblema().getPnListProblem();
                        int index = (item.getLocation().y / (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                        int indentation = pnListProblem.getIndentation().get(index);
                        item.setLocation((indentation * Patron.ITEM_HEIGHT), deltaY * (Patron.ITEM_HEIGHT + Patron.MARGEN_2));

                        finalPos = item.getLocation().y;

                        floatUp(finalPos, originalPos, pnItemListArray, item);
                        floatDown(finalPos, originalPos, pnItemListArray, item);
                        view.getPnLeonetApp().getpProblema().getPnListProblem().updateIdItems();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            item.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    int deltaY = e.getYOnScreen() - item.screenY;
                    PnListProblem pnListProblem = view.getPnLeonetApp().getpProblema().getPnListProblem();
                    int lowerLimit = (pnListProblem.getItemCounts() * (Patron.ITEM_HEIGHT));
                    boolean p = (item.myY + deltaY) > 0;
                    boolean q = (item.myY + deltaY) < lowerLimit;
                    if (p && q) {
                        int index = (item.getLocation().y / (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                        int indentation = pnListProblem.getIndentation().get(index);
                        item.setLocation((indentation * Patron.ITEM_HEIGHT), item.myY + deltaY);
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                }
            });
        }
    }

    private void floatUp(int finalPos, int originalPos, ArrayList<PnItemList> pnItemListArray, PnItemList item) {
        if (finalPos > originalPos) {
            for (PnItemList item_f : pnItemListArray) {
                boolean p = item_f.getLocation().y <= finalPos;
                boolean s = item_f.getLocation().y > originalPos;
                boolean q = item_f != item;
                if (p && q && s) {
                    PnListProblem pnListProblem = view.getPnLeonetApp().getpProblema().getPnListProblem();
                    int index = (item.getLocation().y / (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                    int indentation = pnListProblem.getIndentation().get(index);
                    item_f.setLocation((indentation * Patron.ITEM_HEIGHT), item_f.getLocation().y - (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                }
            }
        }
    }

    private void floatDown(int finalPos, int originalPos, ArrayList<PnItemList> pnItemListArray, PnItemList item) {
        if (finalPos < originalPos) {
            for (PnItemList item_f : pnItemListArray) {
                boolean p = item_f.getLocation().y >= finalPos;
                boolean s = item_f.getLocation().y < originalPos;
                boolean q = item_f != item;
                if (p && q && s) {
                    PnListProblem pnListProblem = view.getPnLeonetApp().getpProblema().getPnListProblem();
                    int index = (item.getLocation().y / (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                    int indentation = pnListProblem.getIndentation().get(index);
                    item_f.setLocation((indentation * Patron.ITEM_HEIGHT), item_f.getLocation().y + (Patron.ITEM_HEIGHT + Patron.MARGEN_2));
                }
            }
        }
    }

    private boolean checkResult(ArrayList positions) {
        UserRepository userProfile = model.getUser().getUserProfile();
        String username = userProfile.getNickname();
        ProblemList pl = model.getProblems().chooseProblemList(username);
        for (ItemList item : pl.getItemListsArray()) {

        }
        return false;
    }
}
