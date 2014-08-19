package gdsl.plugin.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Constant definitions for plug-in preferences
 */
public class GDSLPluginPreferences {
	public static final String PLUGIN_SCOPE = "gdsl.plugin";

	public static final String P_ENABLE_COMPILER = "enableCompiler";
	public static final String P_COMPILER_INVOCATION = "compilerInvocation";
	public static final String P_USE_TYPECHECKER = "useTypechecker";
	public static final String P_ITERATION_TYPECHECKER = "iterationTypechecker";

	public static final boolean D_ENABLE_COMPILER = true;
	public static final String D_COMPILER_INVOCATION = "./build/gdslc";
	public static final boolean D_USE_TYPECHECKER = true;
	public static final int D_ITERATION_TYPECHEKCER = 10;

	public static final String P_OUTPUT_NAME = "outputName";
	public static final String P_HAS_PREFIX = "hasPrefix";
	public static final String P_PREFIX = "prefix";
	public static final String P_RUNTIME_TEMPLATES = "runtimeTemplates";

	public static final String D_OUTPUT_NAME = "gdsl-x86-rreil";
	public static final boolean D_HAS_PREFIX = false;
	public static final String D_PREFIX = "";
	public static final String D_RUNTIME_TEMPLATES = "detail/codegen/c1";

	public static boolean getCompilerEnablement() {
		return getPreferenceStore().getBoolean(P_ENABLE_COMPILER, D_ENABLE_COMPILER);
	}

	public static String getCompilerInvocation() {
		return getPreferenceStore().get(P_COMPILER_INVOCATION, D_COMPILER_INVOCATION);
	}

	public static boolean isTypeCheckerEnabled() {
		return getPreferenceStore().getBoolean(P_USE_TYPECHECKER, D_USE_TYPECHECKER);
	}

	public static int getTypeCheckerIteration() {
		return getPreferenceStore().getInt(P_ITERATION_TYPECHECKER, D_ITERATION_TYPECHEKCER);
	}

	public static String getOutputName(final Resource resource) {
		return getProjectProperties(resource).get(P_OUTPUT_NAME, D_OUTPUT_NAME);
	}

	public static String getPrefix(final Resource resource) {
		final IEclipsePreferences store = getProjectProperties(resource);
		if (store.getBoolean(P_HAS_PREFIX, D_HAS_PREFIX)) {
			return store.get(P_PREFIX, D_PREFIX);
		}
		return null;
	}

	public static String getRuntimeTemplates(final Resource resource) {
		return getProjectProperties(resource).get(P_RUNTIME_TEMPLATES, D_RUNTIME_TEMPLATES);
	}

	/**
	 * Get preference store for the project conaining the resource
	 * 
	 * @param resource
	 *            The resource to get the preference store to
	 * @return The preference store beloning to the resource
	 */
	public static IEclipsePreferences getProjectProperties(final Resource resource) {
		final IProject project = obtainProject(resource);
		final IScopeContext projectScope = new ProjectScope(project);
		return projectScope.getNode(PLUGIN_SCOPE);
	}

	/**
	 * Get the project containing the resource
	 * 
	 * @param resource
	 *            The resource to get the project to
	 * @return The project containing the resource
	 */
	public static IProject obtainProject(final Resource resource) {
		final IPath resourcePath = new Path(resource.getURI().toPlatformString(true));
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getFile(resourcePath).getProject();
		return project;
	}

	/**
	 * Get the preference store for the current eclipse instance
	 * 
	 * @return The preference store for the current eclipse instance
	 */
	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(PLUGIN_SCOPE);
	}

}
