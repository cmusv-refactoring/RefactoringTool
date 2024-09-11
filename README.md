# RefactoringTool: Class Diagram

Starter code for the refactoring tool detector.

OBS. IntelliJ Command to run: run --args="-out _path_in_your_machine_to_save_output_file/output.json -src _path_to_source_code_under_analysis/src"


See **RefactoringTool.pdf** for a simplified class diagram. The RefactoringTool Java project’s class diagram outlines the structure and relationships of various components. Here’s an explanation of the key elements and packages in the diagram:



## Main Class: RefactoringEngine

### Methods:
- `start(String[] args)`: Main entry point of the application.
- `loadAllTypes(List<String> sourcePath)`: Loads and returns a list of Type objects representing all types in the given source paths.
- `collectTypeMetrics(List<Type> types)`: Collects and computes metrics for the provided list of types.
- `saveInfoFile(List<Type> smellyTypes)`: Saves the collected information in the output file.

## Packages and Classes

### A. ast

This package contains classes related to the AST (Abstract Syntax Tree) structure and manipulation.

- **ASTBuilder**: Defines the Java configuration for the project under analysis.
- **CollectorVisitor**: Abstract class to store collected nodes.
    - **Attributes**:
        - `nodesCollected`: List of collected nodes.
    - **Methods**:
        - `addCollectedNode(T node)`: Adds a node to the collected list.
- **Visitors**: Package that contains specific visitors for collecting various AST nodes and metrics.  
  E.g., `MethodCollector`, `TypeDeclarationCollector`, `TypeDeclarationCollector`.
- **Loader**: Main package to load files into resources (Types and Methods).  
  Classes: `SourceFilesLoader`, `JavaFilesFinder`.
- **SourceFile**
    - **Attributes**:
        - `compilationUnit`: Corresponding compilation unit.
- **SourceFileASTRequestor**: Handles AST requests for source files.

### B. resources

This package deals with resources that represent the Java source code.

- **Resource**
    - **Attributes**:
        - `fullyQualifiedName`: Fully qualified name of the resource.
        - `metricsValue`: Map of metric names to their values.
        - `node`: Corresponding AST node.
- **Type**
    - **Attributes**:
        - `methods`: List of methods in the type.
        - `children`: Set of child types.
- **Method**
    - **Attributes**:
        - `parametersTypes`: List of parameter types for the method.
- **ParenthoodRegistry**
    - **Methods**:
        - `registerChild(Type child)`: Registers a child type.

### C. metrics

This package is responsible for calculating and managing various code metrics.

- **MetricValueCollector**: Stores all metric collectors for types (`TypeMetricValueCollector`) and methods (`MethodMetricValueCollector`).
    - **Attributes**:
        - `calculators`: List of `MetricValueCalculator`.
    - **Methods**:
        - `addCalculator(MetricValueCalculator calculator)`: Adds a calculator to the list.
- **Calculators**: Subpackage to store all the method and type metrics.
- **MetricValueCalculator**
    - **Methods**:
        - `computeValue(ASTNode target)`: Computes and returns the metric value for the given AST node.
- **AggregateMetricValues**: Aggregates multiple metric values.

### D. smells

This package contains classes related to detecting different types of code smells.

- **SmellDetector**
    - **Methods**:
        - `detect(Resource resource)`: Detects smells in the given resource.
        - `getSmellName()`: Returns the name of the smell being detected.
- **CompositeSmellDetector**
    - **Methods**:
        - `addDetector(SmellDetector detector)`: Adds a detector to the composite detector.
        - `detect(Resource resource)`: Detects smells using the added detectors.
- **detectors** subpackage: Specific smell detectors for different types of code smells (`GodClass`, `FeatureEnvy`, `LongMethod`, `ShotgunSurgery`).
- **ClassLevelSmellDetector**, **MethodLevelSmellDetector**: Base classes for detectors operating at class and method levels, respectively.
- **Smell**
    - **Attributes**:
        - `name`: The name of the smell.
        - `reason`: The reason or description for the smell.
- **SmellName** (enumeration): Enum representing different types of smells.
- **Thresholds**: Contains thresholds for various smells.

### E. jdt.core (red in the class diagram)

This package corresponds to the JDT Core framework classes, which are used to parse Java source code and return an AST representing the project structure.

- **ASTVisitor**, **ASTParser**, **ASTNode**, **CompilationUnit**: Core JDT classes for working with ASTs.

## Summary

The class diagram illustrates how the RefactoringTool project leverages the JDT Core framework to parse Java source code and construct ASTs. Various packages are designed to detect code smells (`smells`), calculate metrics (`metrics`), manage resources (`resources`), and handle AST manipulation (`ast`). The `RefactoringEngine` class serves as the main entry point, coordinating the detection of code smells across the provided Java source files.


