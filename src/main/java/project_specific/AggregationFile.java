/* 
User: Urmi
Date: 1/22/2020 
Time: 3:57 PM
*/

package project_specific;

public enum AggregationFile {
    TRADES_CSV("trades.csv", MergeKeyType.TRADE_ID, FileType.INPUT){
        @Override
        public Trade deserialize(String str){
            return FilesetManagerHelper.deserializeTrade(str);
        }

        @Override
        public String serialize(Object o){
            return o instanceof Trade ? FilesetManagerHelper.serialize((Trade)o) : "";
        }

        @Override
        public String getMergeKey(Object o){
            return o instanceof Trade ? ((Trade) o).getMergeKey() : "";
        }
    },
    POSITIONS_CSV("positions.csv", MergeKeyType.TRADE_ID, FileType.INPUT){
        @Override
        public Position deserialize(String str){
            return FilesetManagerHelper.deserializePosition(str);
        }

        @Override
        public String serialize(Object o){
            return o instanceof Position ? FilesetManagerHelper.serialize((Position) o) : "";
        }

        @Override
        public String getMergeKey(Object o){
            return o instanceof Trade ? ((Trade) o).getMergeKey() : "";
        }

    },
    PRODUCT_CSV("products.csv", MergeKeyType.CUSIP, FileType.INPUT){
        @Override
        public Product deserialize(String str){
            return FilesetManagerHelper.deserializeProduct(str);
        }

        @Override
        public String serialize(Object o){
            return o instanceof Product ? FilesetManagerHelper.serialize((Product) o) : "";
        }

        @Override
        public String getMergeKey(Object o){
            return o instanceof Trade ? ((Trade) o).getMergeKey() : "";
        }

    };

    private final String fileName;

    private final MergeKeyType mergeKeyType;

    private final FileType fileType;

    AggregationFile(String fileName, MergeKeyType mergeKeyType, FileType fileType) {
        this.fileName = fileName;
        this.mergeKeyType = mergeKeyType;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public MergeKeyType getMergeKeyType() {
        return mergeKeyType;
    }

    public FileType getFileType() {
        return fileType;
    }

    public <T> T deserialize(String str){
        return null;
    }

    public String serialize(Object object){
        return "";
    }

    public String getMergeKey(Object o){
        return "";
    }
}
