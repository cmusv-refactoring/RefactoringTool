package cmu.detector.util;

import cmu.detector.resources.Type;
import cmu.detector.resources.loader.JavaFilesFinder;
import cmu.detector.resources.loader.SourceFile;
import cmu.detector.resources.loader.SourceFilesLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TypeLoader {
	private static HashMap<String, Type> types;

	/**
	 * TODO: load all types from the sourcePath and put them into types HashMap
	 * Example: <"DummyAbstractType", Type [fqn=cmu.csdetector.dummy.kind.DummyAbstractType]>
	 *
	 * @param sourcePath
	 * @throws IOException
	 */
	public static void loadAllFromDir(File sourcePath) throws IOException {
		types = new HashMap<>();

		JavaFilesFinder finder = new JavaFilesFinder(sourcePath.getAbsolutePath());
		SourceFilesLoader loader = new SourceFilesLoader(finder);

		for (SourceFile sourceFile : loader.getLoadedSourceFiles()) {
			for (Type type : sourceFile.getTypes()) {
				//String name = sourceFile.getFile().getName().replace(".java", "");
				String name = type.getNodeAsTypeDeclaration().getName().toString();
				types.put(name, type);
			}
		}

	}

	public static Type findTypeByName(String name) {
		return types.get(name);
	}

	public static List<Type> getTypes() {
		return types.values()
				.stream()
				.toList();
	}
}
