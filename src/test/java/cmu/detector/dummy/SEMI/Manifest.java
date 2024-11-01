package cmu.detector.dummy.SEMI;

public class Manifest {
    String MANIFEST_NAME;

    public Resource[][] grabManifests(Resource[] rcs) {
        Resource[][] manifests = new Resource[rcs.length][];
        for (int i = 0; i < rcs.length; i++) {
            Resource[][] rec;
            if (rcs[i] instanceof FileSet) {
                rec = grabRes(new FileSet[]{(FileSet) rcs[i]});
            } else {
                rec = grabNonFileSetRes(new Resource[]{rcs[i]});
            }
            for (int j = 0; j < rec[0].length; j++) {
                String name = rec[0][j].getName().replace('\\', '/');
                if (rcs[i] instanceof ArchiveFileSet) {
                    ArchiveFileSet afs = (ArchiveFileSet) rcs[i];
                    if (!"".equals(afs.getFullPath(getProj()))) {
                        name = afs.getFullPath(getProj());
                    } else if (!"".equals(afs.getPref(getProj()))) {
                        String pr = afs.getPref(getProj());
                        if (!pr.endsWith("/") && !pr.endsWith("\\")) {
                            pr += "/";
                        }
                        name = pr + name;
                    }
                }
                if (name.equalsIgnoreCase(MANIFEST_NAME)) {
                    manifests[i] = new Resource[]{rec[0][j]};
                    break;
                }
            }
            if (manifests[i] == null) {
                manifests[i] = new Resource[0];
            }
        }
        return manifests;
    }

    // Dummy implementation of grabRes
    public Resource[][] grabRes(FileSet[] fileSets) {
        Resource[][] resources = new Resource[fileSets.length][1];
        for (int i = 0; i < fileSets.length; i++) {
            resources[i][0] = fileSets[i]; // Assuming a simple transformation for testing
        }
        return resources;
    }

    // Dummy implementation of grabNonFileSetRes
    public Resource[][] grabNonFileSetRes(Resource[] resources) {
        Resource[][] resArray = new Resource[resources.length][1];
        for (int i = 0; i < resources.length; i++) {
            resArray[i][0] = resources[i]; // Assuming a simple transformation for testing
        }
        return resArray;
    }

    // Dummy implementation of getProj
    public Integer getProj() {
        return 1; // Return a dummy project ID
    }

    public static void main(String[] args) {
        // Create instances of Resource, FileSet, and ArchiveFileSet
        Resource resource1 = new Resource();
        FileSet fileSet = new FileSet();
        ArchiveFileSet archiveFileSet = new ArchiveFileSet();

        // Set up any necessary properties for each instance (e.g., names, paths)
        resource1.setName("resource1");
        fileSet.setName("fileSet1");
        archiveFileSet.setName("archiveFileSet1");

        // Set the manifest name to match one of the resource names for testing
        Manifest manifest = new Manifest();
        manifest.MANIFEST_NAME = "resource1";

        // Create an array of Resources to pass to grabManifests
        Resource[] resources = {resource1, fileSet, archiveFileSet};

        // Call grabManifests and store the result
        Resource[][] result = manifest.grabManifests(resources);

        // Print the results to verify the behavior
        System.out.println("Grabbed Manifests:");
        for (Resource[] resourceArray : result) {
            for (Resource res : resourceArray) {
                System.out.println(res.getName());
            }
        }
    }
}
