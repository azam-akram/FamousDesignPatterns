public class MatchUpdaterFactory {

    private static FootballLiveCoverageServiceImpl footballMatchUpdater;

    public static LiveCoverageService getUpdater(MatchType type) {
        switch (type) {
            case FOOTBALL:
                if (footballMatchUpdater == null) {
                    synchronized (FootballLiveCoverageServiceImpl.class) {
                        footballMatchUpdater = new FootballLiveCoverageServiceImpl();
                    }
                }
                return footballMatchUpdater;
            case CRICKET:
            case TENNIS:
            default:
                    return null;
        }
    }
}
