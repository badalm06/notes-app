package com.notesapp.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/notesapp/ui/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AddNote", "EditNote", "Login", "NotesList", "Lcom/notesapp/ui/Screen$AddNote;", "Lcom/notesapp/ui/Screen$EditNote;", "Lcom/notesapp/ui/Screen$Login;", "Lcom/notesapp/ui/Screen$NotesList;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/ui/Screen$AddNote;", "Lcom/notesapp/ui/Screen;", "()V", "app_debug"})
    public static final class AddNote extends com.notesapp.ui.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.notesapp.ui.Screen.AddNote INSTANCE = null;
        
        private AddNote() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/notesapp/ui/Screen$EditNote;", "Lcom/notesapp/ui/Screen;", "()V", "createRoute", "", "noteId", "", "app_debug"})
    public static final class EditNote extends com.notesapp.ui.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.notesapp.ui.Screen.EditNote INSTANCE = null;
        
        private EditNote() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(int noteId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/ui/Screen$Login;", "Lcom/notesapp/ui/Screen;", "()V", "app_debug"})
    public static final class Login extends com.notesapp.ui.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.notesapp.ui.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/ui/Screen$NotesList;", "Lcom/notesapp/ui/Screen;", "()V", "app_debug"})
    public static final class NotesList extends com.notesapp.ui.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.notesapp.ui.Screen.NotesList INSTANCE = null;
        
        private NotesList() {
        }
    }
}