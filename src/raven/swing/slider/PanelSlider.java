package raven.swing.slider;

import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.CubicBezierEasing;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.VolatileImage;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

// PanelSlider is a custom component that allows smooth sliding transitions 
//  between different components using animations.
//  It uses a snapshot of the old and new components for seamless transitions.
public class PanelSlider extends JLayeredPane {
     // A component to hold a snapshot of the old and new components during transitions
    private PanelSnapshot panelSnapshot;
    
    // The currently displayed component
    private Component component;
    
    // The previously displayed component (used for transitions)
    private Component oldComponent;

    // Constructor: Initializes the panel slider
    public PanelSlider() {
        init();
    }

  // Initializes the panel slider
    private void init() {
        setOpaque(true); // Makes the component opaque
        panelSnapshot = new PanelSnapshot(); // Creates the snapshot panel
        setLayout(new CardLayout()); // Uses CardLayout for component switching
        setLayer(panelSnapshot, JLayeredPane.DRAG_LAYER); // Places the snapshot panel on top
        add(panelSnapshot); // Adds the snapshot panel to the layout
        panelSnapshot.setVisible(false); // Initially hides the snapshot panel
    }

     /**
     * Adds a new component to the slider with a transition effect.
     * If a transition is provided, it captures snapshots of the old and new components
     * to perform an animated slide effect.
     *
     * @param component  The new component to be displayed
     * @param transition The transition effect to be applied
     */
    public void addSlide(Component component, SliderTransition transition) {
        component.applyComponentOrientation(getComponentOrientation()); // Ensures proper orientation
        
        if (this.component != null) {
            this.oldComponent = this.component; // Stores the previous component
        }
        this.component = component; // Updates the current component

        if (oldComponent == null) {
            // If there's no previous component, simply add and display the new one
            add(component);
            repaint();
            revalidate();
            component.setVisible(true);
        } else {
            add(component); // Adds the new component to the layout
            
            if (transition != null) {
                doLayout(); // Updates layout before animation
                SwingUtilities.invokeLater(() -> {
                    // Captures snapshots of the old and new components
                    Image oldImage = createImage(oldComponent);
                    Image newImage = createImage(component);
                    remove(oldComponent); // Removes the old component from the layout
                    panelSnapshot.animate(transition, oldImage, newImage); // Starts the animation
                });
            } else {
                // If no transition is provided, simply switch components
                component.setVisible(true);
                remove(oldComponent);
                revalidate();
                repaint();
            }
        }
    }

     /**
     * Creates an image snapshot of the given component.
     * This is used for smooth transition animations.
     *
     * @param component The component to capture
     * @return An image snapshot of the component
     */
    public Image createImage(Component component) {
        boolean check = false;
        for (Component com : getComponents()) {
            if (com == component) {
                check = true;
                break;
            }
        }
        if (!check) {
            add(component);
        }
        VolatileImage snapshot = component.createVolatileImage(getWidth(), getHeight());
        if (snapshot == null) {
            return null;
        }
        component.paint(snapshot.getGraphics()); // Paints the component onto the image
        if (!check) {
            remove(component);
        }
        return snapshot;
    }

    /**
     * Creates an image snapshot of the previously displayed component.
     *
     * @return An image of the old component, or null if none exists
     */
    public Image createOldImage() {
        if (oldComponent != null) {
            return createImage(oldComponent);
        }
        return null;
    }

    // PanelSnapshot is responsible for handling the animation between components.
    private class PanelSnapshot extends JComponent {

        @Override
        public void updateUI() {
            super.updateUI();
            if (sliderTransition != null && !sliderTransition.closeAfterAnimation()) {
                if (oldComponent != null) {
                    SwingUtilities.updateComponentTreeUI(oldComponent);
                    oldImage = PanelSlider.this.createImage(oldComponent);
                }
            }
        }

         // Animation-related properties
        private final Animator animator; // Controls the animation timing
        private float animate; // Stores the animation progress (0 to 1)

        private SliderTransition sliderTransition; // The transition effect
        private Image oldImage; // Snapshot of the old component
        private Image newImage; // Snapshot of the new component

        // Constructor: Initializes the animation settings
        public PanelSnapshot() {
            animator = new Animator(400, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    animate = v; // Updates animation progress
                    repaint(); // Triggers a repaint to reflect animation changes
                }

                @Override
                public void end() {
                    if (sliderTransition.closeAfterAnimation()) {
                        setVisible(false); // Hides the snapshot panel after animation
                        oldImage.flush(); // Releases memory for the old image
                        newImage.flush(); // Releases memory for the new image
                    }
                    component.setVisible(true); // Ensures the new component is visible
                }
            });
            animator.setInterpolator(CubicBezierEasing.EASE); // Applies smooth easing to animation
        }
        
        /**
         * Starts the animation between the old and new component images.
         *
         * @param sliderTransition The transition effect to apply
         * @param oldImage Snapshot of the old component
         * @param newImage Snapshot of the new component
         */
        protected void animate(SliderTransition sliderTransition, Image oldImage, Image newImage) {
            if (animator.isRunning()) {
                animator.stop();
            }
            this.oldImage = oldImage;
            this.newImage = newImage;
            this.sliderTransition = sliderTransition;
            this.animate = 0f; // Stops any ongoing animation before starting a new one
            repaint();
            setVisible(true); // Resets animation progress
            animator.start(); // Starts the animation
        }

        @Override
        public void paint(Graphics g) {
            if (sliderTransition != null) {
                int width = getWidth();
                int height = getHeight();
                // Delegates the rendering of the transition effect
                sliderTransition.render(this, g, oldImage, newImage, width, height, animate);
            }
        }
    }
}
